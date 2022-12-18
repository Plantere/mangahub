package br.com.mangahub.services;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.mangahub.interfaces.MangaRepositoryInterface;
import br.com.mangahub.models.Mangas;

@Service
public class MangaService {
    @Autowired
    private MangaRepositoryInterface mangaRepository;

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
}
