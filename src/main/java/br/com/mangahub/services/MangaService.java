package br.com.mangahub.services;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.mangahub.interfaces.MangaRepositoryInterface;
import br.com.mangahub.models.Mangas;

@Service
public class MangaService {
    @Autowired
    private MangaRepositoryInterface mangaRepository;

    @Autowired
    private ChapterPageService chapterPageService;

    @Autowired
    private FavoriteService favoriteService;

    @Autowired
    private ChapterService chapterService;


    public Page<Mangas> findAllByDeletedAtIsNull(Integer page){
        return mangaRepository.findAllByDeletedAtIsNull(PageRequest.of(page, 12));

    }
    public boolean saveManga(Mangas manga, MultipartFile imageCover){
        manga.setMangaCover(getImageByte(imageCover));
        mangaRepository.save(manga);
        return true;
    }

    public boolean updateManga(Long mangaID, Mangas manga, MultipartFile imageCover){
        if(imageCover.isEmpty()){
            Optional<Mangas> mangaOriginal = mangaRepository.findById(mangaID);
            manga.setMangaCover(mangaOriginal.get().getMangaCover());
        }else{
            manga.setMangaCover(getImageByte(imageCover));
        }

        manga.setId(mangaID);
        mangaRepository.save(manga);
        return true;
    }

    public byte[] getImageByte(MultipartFile image){
        byte[] imageByte = new byte[0];
        
        try{
            imageByte = new byte[image.getBytes().length];

            int i = 0;
    
            for (byte b : image.getBytes()){
                imageByte[i++] = b;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return imageByte;
    }

    public boolean deleteManga(Long mangaID){
        mangaRepository.deleteById(mangaID);
        favoriteService.deleteByMangaId(mangaID);
        chapterService.deleteByMangaId(mangaID);
        return true;
    }
}
