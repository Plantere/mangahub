package br.com.mangahub.controllers;

import br.com.mangahub.interfaces.ChapterRepositoryInterface;
import br.com.mangahub.interfaces.MangaRepositoryInterface;
import br.com.mangahub.models.Chapters;
import br.com.mangahub.models.ChaptersPages;
import br.com.mangahub.models.Mangas;
import br.com.mangahub.services.ChapterPageService;
import br.com.mangahub.services.ChapterService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ChapterController {
    @Autowired
    private ChapterRepositoryInterface chapterRepository;
    
    @Autowired
    private ChapterPageService chapterPageService;

    @Autowired
    private ChapterService chapterService;
    
    @Autowired
    private MangaRepositoryInterface mangaRepository;
    
    @GetMapping("/manga/{mangaID}/capitulo/registrar")
    public String redirectRegisterChapter(@PathVariable(required=true, name="mangaID") Long mangaID, Model model, Chapters chapter){
        if(mangaRepository.findById(mangaID).isPresent() == false){
            return "redirect:/";
        }

        model.addAttribute("chapter", chapter);
        
        return "manga/admin/capitulo/registrarCapitulos";
    }

    @GetMapping("/manga/{mangaID}/capitulo/{capituloID}/atualizar")
    public String redirectUpdateChapter(@PathVariable(required=true, name="mangaID") Long mangaID, @PathVariable(required=true, name="capituloID") Long capituloID, Model model){
        if(mangaRepository.findById(mangaID).isPresent() == false){
            return "redirect:/";
        }

        Optional<Chapters> chapter = chapterRepository.findById(capituloID);
        if(chapter.isPresent() == false){
            return "redirect:/";
        }

        model.addAttribute("chapter", chapter);

        return "manga/admin/capitulo/atualizarCapitulo";
    }

    @GetMapping("/capitulo/{capituloID}/registrar/pagina")
    public String redirectRegisterChapterPage(@PathVariable(required=true, name="capituloID") Long capituloID, Model model, ChaptersPages chaptersPages){
        if(chapterRepository.findById(capituloID).isPresent() == false){
            return "redirect:/";
        }

        model.addAttribute("chaptersPage", chaptersPages);
        model.addAttribute("capituloID", capituloID);
        return "manga/admin/capitulo/paginas/registrarPaginas";
    }

    @PostMapping("/capitulo/{capituloID}/registrar/pagina")
    public String createChapterPage(@PathVariable(required=true, name="capituloID") Long capituloID, @RequestParam("imagePageFile") MultipartFile imagePage, ChaptersPages chaptersPages){
        Optional<Chapters> chapter = chapterRepository.findById(capituloID);
        if(chapter.isPresent() == false){
            return "redirect:/";
        }

        chaptersPages.setChapter(chapter.get());
        chapterPageService.saveChapterPage(chaptersPages, imagePage);
        
        return "redirect:/";
    }

    @PostMapping("/manga/{mangaID}/capitulo/registrar")
    public String createChapter(@PathVariable(required=true, name="mangaID") Long mangaID, Chapters chapter){
        Optional<Mangas> manga = mangaRepository.findById(mangaID);

        if(manga.isPresent() == false){
            return "redirect:/";
        }

        chapter.setManga(manga.get());
        chapterService.saveChapter(chapter);

        return "redirect:/";
    }

    @PostMapping("/manga/{mangaID}/capitulo/{capituloID}/atualizar")
    public String updateChapter(@PathVariable(required=true, name="mangaID") Long mangaID, @PathVariable(required=true, name="capituloID") Long capituloID, Chapters chapter){
        Optional<Mangas> manga = mangaRepository.findById(mangaID);
        
        if(manga.isPresent() == false || chapterRepository.findById(capituloID).isPresent() == false){
            return "redirect:/";
        }
        
        chapter.setManga(manga.get());
        chapterService.updateChapter(capituloID, chapter);

        return "redirect:/";
    }
}
