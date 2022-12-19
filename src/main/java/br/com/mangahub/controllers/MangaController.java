package br.com.mangahub.controllers;
import br.com.mangahub.interfaces.MangaRepositoryInterface;
import br.com.mangahub.interfaces.UserRepositoryInterface;
import br.com.mangahub.models.Mangas;
import br.com.mangahub.models.Users;
import br.com.mangahub.services.MangaService;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.Principal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.ui.Model;

@Controller
public class MangaController {
    @Autowired
    private MangaService mangaService;
    
    @Autowired
    private MangaRepositoryInterface mangaRepository;

    @Autowired
    private UserRepositoryInterface userRepository;

    @GetMapping("/manga")
    public String listMangas(@RequestParam() Optional<Integer> page, Model model){
        int currentPage = page.orElse(1) - 1;

        Page<Mangas> mangaPage = mangaService.findAllByDeletedAtIsNull(currentPage);
        model.addAttribute("mangas", mangaPage);
        
        int totalPages = mangaPage.getTotalPages();
        List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                                            .boxed()
                                            .collect(Collectors.toList());
        
        model.addAttribute("pageNumbers", pageNumbers);
        return "manga/mostrarManga";
    }
    
    @GetMapping("/manga/{mangaID}")
    public String getMangaById(Principal principal, @PathVariable(required=true, name="mangaID") Long mangaID, Model model){
        Mangas manga = mangaRepository.findOneByIdAndDeletedAtIsNull(mangaID);
        
        if(principal != null){
            Users user = userRepository.findOneByEmailAndDeletedAtIsNull(principal.getName());
            model.addAttribute("user", user);
        }

        model.addAttribute("manga", manga);

        return "manga/mostrarMangaEspecifico";
    }
    

    @GetMapping("/manga/registrar") // Registrar Manga
    public String redirectRegister(Mangas manga, Model model){
        model.addAttribute("manga", manga);
    
        return "manga/admin/registrarManga";
    }

    @GetMapping("/manga/atualizar/{mangaID}") // Atualizar Manga
    public String redirectUpdate(@PathVariable(required=true, name="mangaID") Long mangaID, Model model){
        Optional<Mangas> manga = mangaRepository.findById(mangaID);

        if(manga.isPresent() == false){
            return "redirect:/";
        }

        model.addAttribute("manga", manga.get());
        
        return "manga/admin/atualizarManga";
    }

    @PostMapping("/manga/registrar") // Registrar Manga
    public String createManga(@RequestParam("imageCover") MultipartFile imageCover, Mangas manga){
        mangaService.saveManga(manga, imageCover);
        return "redirect:/";
    }

    @PostMapping("/manga/atualizar/{mangaID}") // Atualizar Manga
    public String updateManga(@RequestParam("imageCover") MultipartFile imageCover, @PathVariable(required=true, name="mangaID") Long mangaID, Mangas manga){
        mangaService.updateManga(mangaID, manga, imageCover);
        return "redirect:/";
    }
}
