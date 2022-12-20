package br.com.mangahub.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mangahub.interfaces.ChapterPageRepositoryInterface;
import br.com.mangahub.models.ChaptersPages;

@Service
public class ChapterPageService {
    @Autowired
    private ChapterPageRepositoryInterface chapterPageRepository;
    
    public boolean saveChapterPage(ChaptersPages chapterPage){
        chapterPageRepository.save(chapterPage);
        
        return true;
    }

    public boolean deleteByChapterId(Long chapterID){
        chapterPageRepository.deleteByChapterId(chapterID);
        return true;
    }
    
    public Boolean deleteByMangaId(Long mangaID){
        chapterPageRepository.deleteByMangaId(mangaID);
        
        return true;
    }
}
