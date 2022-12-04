package br.com.mangahub.controllers;

import br.com.mangahub.interfaces.ChapterRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChapterController {
    @Autowired
    private ChapterRepositoryInterface chapterRepository;

    @GetMapping("/")
    public String getChapter(Model model){
        return "index.html";
    }
}
