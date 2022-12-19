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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.ui.Model;

@Controller
public class AdminMangaController {
    @Autowired
    private MangaService mangaService;
    
    @Autowired
    private MangaRepositoryInterface mangaRepository;

    @GetMapping("/admin/manga/registrar")
    public String redirectRegisterMangaPage(Mangas manga, Model model){
        model.addAttribute("manga", manga);
    
        return "manga/admin/registrarManga";
    }

    @GetMapping("/admin/manga/atualizar/{mangaID}")
    public String redirectUpdateMangaPage(@PathVariable(required=true, name="mangaID") Long mangaID, Model model){
        Optional<Mangas> manga = mangaRepository.findById(mangaID);

        if(manga.isPresent() == false){
            return "redirect:/";
        }

        model.addAttribute("manga", manga.get());
        
        return "manga/admin/atualizarManga";
    }

    @PostMapping("/admin/manga/registrar")
    public String createManga(@RequestParam("imageCover") MultipartFile imageCover, Mangas manga){
        mangaService.saveManga(manga, imageCover);
        return "redirect:/";
    }

    @PostMapping("/admin/manga/atualizar/{mangaID}")
    public String updateManga(@RequestParam("imageCover") MultipartFile imageCover, @PathVariable(required=true, name="mangaID") Long mangaID, Mangas manga){
        mangaService.updateManga(mangaID, manga, imageCover);
        return "redirect:/manga/"+mangaID;
    }

    @GetMapping("/admin/manga/deletar/{mangaID}")
    public String deleteManga(@PathVariable(required=true, name="mangaID") Long mangaID){
        mangaService.deleteManga(mangaID);
        return "redirect:/";
    }

}
