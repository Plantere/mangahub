package br.com.mangahub.controllers;

import br.com.mangahub.interfaces.ChapterRepositoryInterface;
import br.com.mangahub.interfaces.MangaRepositoryInterface;
import br.com.mangahub.models.Chapters;
import br.com.mangahub.models.Mangas;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ChapterController {
    @Autowired
    private ChapterRepositoryInterface chapterRepository;
    
    @Autowired
    private MangaRepositoryInterface mangaRepository;
    
    @GetMapping("/manga/{mangaID}/capitulo/registrar")
    public String redirectRegister(@PathVariable(required=true, name="mangaID") Long mangaID, Model model, Chapters chapter){
        if(mangaRepository.findById(mangaID).isPresent() == false){
            return "redirect:/";
        }

        model.addAttribute("chapter", chapter);
        
        return "manga/admin/capitulo/registrar";
    }

    @GetMapping("/manga/{mangaID}/capitulo/{capituloID}/atualizar")
    public String redirectUpdate(@PathVariable(required=true, name="mangaID") Long mangaID, @PathVariable(required=true, name="capituloID") Long capituloID, Model model){
        if(mangaRepository.findById(mangaID).isPresent() == false){
            return "redirect:/";
        }

        Optional<Chapters> chapter = chapterRepository.findById(capituloID);
        if(chapter.isPresent() == false){
            return "redirect:/";
        }

        model.addAttribute("chapter", chapter);
        return "manga/admin/capitulo/atualizar";
    }

}
