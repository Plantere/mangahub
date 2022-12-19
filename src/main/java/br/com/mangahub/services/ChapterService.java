package br.com.mangahub.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mangahub.interfaces.ChapterRepositoryInterface;
import br.com.mangahub.models.Chapters;

@Service
public class ChapterService {
    @Autowired
    private ChapterPageService chapterPageService;

    @Autowired
    private ChapterRepositoryInterface chapterRepository;

    public boolean saveChapter(Chapters chapter){
        chapterRepository.save(chapter);
        return true;
    }

    
    public boolean updateChapter(Long capituloID, Chapters chapter){
        chapter.setId(capituloID);
        chapterRepository.save(chapter);
        return true;
    }

    public boolean deleteChapter(Chapters chapter){
        Long chapterID = chapter.getId();
        chapterRepository.deleteById(chapterID);
        chapterPageService.deleteByChapterId(chapterID);
        return true;
    }

}
