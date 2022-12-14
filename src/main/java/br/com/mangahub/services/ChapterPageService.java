package br.com.mangahub.services;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.mangahub.interfaces.ChapterPageRepositoryInterface;
import br.com.mangahub.interfaces.ChapterRepositoryInterface;
import br.com.mangahub.models.ChaptersPages;

@Service
public class ChapterPageService {
    @Autowired
    private ChapterPageRepositoryInterface chapterPageRepository;
    
    @Autowired
    private ChapterRepositoryInterface chapterRepository;

    public boolean saveChapterPage(ChaptersPages chapterPage, MultipartFile imagePage){
        chapterPage.setImagePage(getImageByte(imagePage));
        chapterPageRepository.save(chapterPage);
        
        return true;
    }

    public byte[] getImageByte(MultipartFile imagePage){
        byte[] imagePageByte = new byte[0];
        
        try{
            imagePageByte = new byte[imagePage.getBytes().length];

            int i = 0;
    
            for (byte b : imagePage.getBytes()){
                imagePageByte[i++] = b;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return imagePageByte;
    }
}
