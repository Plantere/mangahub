package br.com.mangahub.controllers;

import br.com.mangahub.interfaces.ChapterPageRepositoryInterface;
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

@Controller
public class ChapterController {
    @Autowired
    private ChapterRepositoryInterface chapterRepository;

    @Autowired
    private ChapterPageRepositoryInterface chapterPageRepository;

    @Autowired
    private ChapterPageService chapterPageService;

    @Autowired
    private ChapterService chapterService;

    @Autowired
    private MangaRepositoryInterface mangaRepository;

    @GetMapping("/manga/{mangaID}/capitulo/{capituloID}") // Registrar capitulos
    public String showChapter(@PathVariable(required=true, name="mangaID") Long mangaID, @PathVariable(required=true, name="capituloID") Long capituloID, Model model){
        Optional<Chapters> chapter = chapterRepository.findById(capituloID);
        if(chapter.isPresent() == false){
            return "redirect:/";
        }

        model.addAttribute("chapter", chapter.get());

        return "manga/mostrarCapitulo";
    }

    @GetMapping("/admin/manga/{mangaID}/capitulo/registrar") // Registrar capitulo
    public String redirectRegisterChapter(@PathVariable(required=true, name="mangaID") Long mangaID, Model model, Chapters chapter){
        if(mangaRepository.existsById(mangaID) == false){
            return "redirect:/";
        }

        model.addAttribute("chapter", chapter);
        
        return "manga/admin/capitulo/registrarCapitulos";
    }

    @GetMapping("/admin/manga/{mangaID}/capitulo/{capituloID}/atualizar") // Atualizar capitulo
    public String redirectUpdateChapter(@PathVariable(required=true, name="mangaID") Long mangaID, @PathVariable(required=true, name="capituloID") Long capituloID, Model model){
        if(mangaRepository.existsById(mangaID) == false){
            return "redirect:/";
        }

        Optional<Chapters> chapter = chapterRepository.findById(capituloID);
        if(chapter.isPresent() == false){
            return "redirect:/";
        }

        model.addAttribute("chapter", chapter.get());

        return "manga/admin/capitulo/atualizarCapitulos";
    }

    @GetMapping("/admin/capitulo/{capituloID}/registrar/pagina") // Registrar pagina
    public String redirectRegisterChapterPage(@PathVariable(required=true, name="capituloID") Long capituloID, Model model, ChaptersPages chaptersPages){
        if(chapterRepository.existsById(capituloID) == false){
            return "redirect:/";
        }

        model.addAttribute("chaptersPage", chaptersPages);
        model.addAttribute("capituloID", capituloID);
        
        return "manga/admin/capitulo/paginas/registrarPaginas";
    }

    @PostMapping("/admin/capitulo/{capituloID}/deletar") // Deletar Capitulo
    public String deleteChapter(@PathVariable(required=true, name="capituloID") Long capituloID){
        Optional<Chapters> chapter = chapterRepository.findById(capituloID);

        if(chapter.isPresent() == false){
            return "redirect:/";
        }

        chapterService.deleteChapter(chapter.get());

        return "redirect:/";
    }

    @GetMapping("/admin/capitulo/{capituloID}/pagina/{paginaNumero}/deletar") // Deletar Pagina
    public String deleteChapterPage(@PathVariable(required=true, name="capituloID") Long capituloID, @PathVariable(required=true, name="paginaNumero") int paginaNumero){
        if(chapterPageRepository.findByChapterIdAndPage(capituloID, paginaNumero).isPresent() == false){
            return "redirect:/";
        }

        chapterPageRepository.deleteByChapterIdAndPage(capituloID, paginaNumero);
        return "redirect:/";
    }

    @PostMapping("/admin/capitulo/{capituloID}/registrar/pagina") // Registrar Pagina
    public String createChapterPage(@PathVariable(required=true, name="capituloID") Long capituloID, ChaptersPages chaptersPages){
        Optional<Chapters> chapter = chapterRepository.findById(capituloID);
        if(chapter.isPresent() == false){
            return "redirect:/";
        }

        chaptersPages.setChapter(chapter.get());
        chapterPageService.saveChapterPage(chaptersPages);
        
        return "redirect:/";
    }

    @PostMapping("/admin/manga/{mangaID}/capitulo/registrar") // Registrar capitulo
    public String createChapter(@PathVariable(required=true, name="mangaID") Long mangaID, Chapters chapter){
        Optional<Mangas> manga = mangaRepository.findById(mangaID);

        if(manga.isPresent() == false){
            return "redirect:/";
        }

        chapter.setManga(manga.get());
        chapterService.saveChapter(chapter);

        return "redirect:/manga/"+mangaID;
    }

    @PostMapping("/admin/manga/{mangaID}/capitulo/{capituloID}/atualizar") // Atualizar capitulo
    public String updateChapter(@PathVariable(required=true, name="mangaID") Long mangaID, @PathVariable(required=true, name="capituloID") Long capituloID, Chapters chapter){
        Optional<Mangas> manga = mangaRepository.findById(mangaID);
        
        if(manga.isPresent() == false || chapterRepository.findById(capituloID).isPresent() == false){
            return "redirect:/";
        }
        
        chapter.setManga(manga.get());
        chapterService.updateChapter(capituloID, chapter);

        return "redirect:/manga/"+mangaID;
    }

    @GetMapping("/admin/manga/{mangaID}/capitulo/{capituloID}/deletar") // Atualizar capitulo
    public String deletarChapter(@PathVariable(required=true, name="mangaID") Long mangaID, @PathVariable(required=true, name="capituloID") Long capituloID){
        chapterRepository.deleteById(capituloID);
        return "redirect:/manga/"+mangaID;
    }
}
