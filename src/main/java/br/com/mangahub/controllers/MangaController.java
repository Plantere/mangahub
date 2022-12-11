package br.com.mangahub.controllers;
import br.com.mangahub.interfaces.MangaRepositoryInterface;
import br.com.mangahub.models.Mangas;
import br.com.mangahub.services.MangaService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

@Controller
public class MangaController {
    @Autowired
    private MangaService mangaService;
    
    @Autowired
    private MangaRepositoryInterface mangaRepository;

    @GetMapping("/manga/registrar")
    public String redirectRegister(Mangas manga, Model model){
        model.addAttribute("manga", manga);
        return "manga/admin/registrar";
    }

    @GetMapping("/manga/atualizar/{mangaID}")
    public String redirectUpdate(@PathVariable(required=true, name="mangaID") Long mangaID, Model model){
        Optional<Mangas> manga = mangaRepository.findById(mangaID);

        if(manga.isPresent() == false){
            return "redirect:/";
        }

        model.addAttribute("manga", manga.get());
        
        return "manga/admin/atualizar";
    }

    @PostMapping("/manga/registrar")
    public String createManga(Mangas manga){
        mangaService.saveManga(manga);
        return "redirect:/";
    }

    @PostMapping("/manga/atualizar/{mangaID}")
    public String updateManga(@PathVariable(required=true, name="mangaID") Long mangaID, Mangas manga){
        mangaService.updateManga(mangaID, manga);
        return "redirect:/";
    }


}
