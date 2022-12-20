package br.com.mangahub.controllers;
import br.com.mangahub.interfaces.MangaRepositoryInterface;
import br.com.mangahub.interfaces.UserRepositoryInterface;
import br.com.mangahub.models.Mangas;
import br.com.mangahub.models.Users;
import br.com.mangahub.models.filters.MangasFilter;
import br.com.mangahub.services.MangaService;
import java.security.Principal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.domain.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
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
    
    @GetMapping("/manga/pesquisar")
    public String searchMangas(MangasFilter filtro, Model model, @PageableDefault(size = 12) @SortDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable, HttpServletRequest request){
        
		Page<Mangas> mangasPage = mangaRepository.pesquisar(filtro, pageable);

		model.addAttribute("mangas", mangasPage);
        
        int totalPages = mangasPage.getTotalPages();
        List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                                            .boxed()
                                            .collect(Collectors.toList());
        
        model.addAttribute("pageNumbers", pageNumbers);

        return "manga/pesquisarManga";
    }
}
