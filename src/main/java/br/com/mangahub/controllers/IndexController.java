package br.com.mangahub.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.mangahub.interfaces.ChapterRepositoryInterface;

@Controller
public class IndexController {
    @Autowired
    private ChapterRepositoryInterface chapterRepository;

    @GetMapping("/")
    public String index(Model model) {
        // model.addAttribute("recents_chapters", chapterRepository.findTop10ByOrderByCreatedAt(pageable));
        return "index";
    }
}
