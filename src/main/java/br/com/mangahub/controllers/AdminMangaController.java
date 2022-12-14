package br.com.mangahub.controllers;
import br.com.mangahub.interfaces.MangaRepositoryInterface;
import br.com.mangahub.models.Mangas;
import br.com.mangahub.services.MangaService;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

@Controller
public class AdminMangaController {
    @Autowired
    private MangaService mangaService;
    
    @Autowired
    private MangaRepositoryInterface mangaRepository;

    @GetMapping("/admin/manga/registrar")
    public String redirectRegisterMangaPage(Mangas manga, BindingResult result,Model model){
        model.addAttribute("errors", result);
        model.addAttribute("manga", manga);
    
        return "manga/admin/registrarManga";
    }

    @GetMapping("/admin/manga/atualizar/{mangaID}")
    public String redirectUpdateMangaPage(@PathVariable(required=false, name="mangaID") Long mangaID, Model model){
        Optional<Mangas> manga = mangaRepository.findById(mangaID);

        if(manga.isPresent() == false){
            return "redirect:/";
        }

        model.addAttribute("manga", manga.get());
        
        return "manga/admin/atualizarManga";
    }

    @PostMapping("/admin/manga/registrar")
    public String createManga(@Valid Mangas manga, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("errors", result);
            model.addAttribute("manga", manga);
            return "manga/admin/registrarManga";
        }

        mangaService.saveManga(manga);
        return "redirect:/";
    }

    @PostMapping("/admin/manga/atualizar/{mangaID}")
    public String updateManga(@PathVariable(required=false, name="mangaID") Long mangaID, Mangas manga, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("manga", manga);
            return "manga/admin/atualizarManga";
        }

        mangaService.updateManga(mangaID, manga);
        return "redirect:/manga/"+mangaID;
    }

    @GetMapping("/admin/manga/deletar/{mangaID}")
    public String deleteManga(@PathVariable(required=true, name="mangaID") Long mangaID){
        mangaService.deleteManga(mangaID);
        return "redirect:/";
    }

}
