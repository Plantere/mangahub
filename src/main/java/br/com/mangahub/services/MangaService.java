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
    private FavoriteService favoriteService;

    @Autowired
    private ChapterService chapterService;


    public Page<Mangas> findAllByDeletedAtIsNull(Integer page){
        return mangaRepository.findAllByDeletedAtIsNull(PageRequest.of(page, 12));

    }
    public boolean saveManga(Mangas manga){
        mangaRepository.save(manga);
        return true;
    }

    public boolean updateManga(Long mangaID, Mangas manga){
        manga.setId(mangaID);
        mangaRepository.save(manga);
        return true;
    }

    public boolean deleteManga(Long mangaID){
        mangaRepository.deleteById(mangaID);
        favoriteService.deleteByMangaId(mangaID);
        chapterService.deleteByMangaId(mangaID);
        return true;
    }
}
