package br.com.mangahub.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mangahub.interfaces.MangaRepositoryInterface;
import br.com.mangahub.models.Mangas;

@Service
public class MangaService {
    @Autowired
    private MangaRepositoryInterface mangaRepository;

    public boolean saveManga(Mangas manga){
        mangaRepository.save(manga);
        return true;
    }

    public boolean updateManga(Long mangaID, Mangas manga){
        manga.setId(mangaID);
        mangaRepository.save(manga);
        return true;
    }
}
