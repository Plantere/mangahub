package br.com.mangahub.controllers;
import br.com.mangahub.interfaces.FavoriteRepositoryInterface;
import br.com.mangahub.interfaces.UserRepositoryInterface;
import br.com.mangahub.models.Favorites;
import br.com.mangahub.models.Users;
import br.com.mangahub.services.FavoriteService;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FavoriteController {
    @Autowired
    private FavoriteRepositoryInterface favoriteRepository;

    @Autowired
    private UserRepositoryInterface userRepository;

    @Autowired
    private FavoriteService favoriteService;

    @GetMapping("/favoritos")
    public String getFavorites(@RequestParam(defaultValue = "0") String page, Model model, Principal principal){
        Users user = userRepository.findOneByEmailAndDeletedAtIsNull(principal.getName());

        Page<Favorites> favoritePage = favoriteService.findAllByUserAndDeletedAtIsNull(user, Integer.parseInt(page));
        model.addAttribute("favorites", favoritePage);
        
        int totalPages = favoritePage.getTotalPages();
        List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                                            .boxed()
                                            .collect(Collectors.toList());
        
        model.addAttribute("pageNumbers", pageNumbers);

        return "favoritos/mostrarFavoritos";
    }
    
    @GetMapping("/favorito/adicionar/{mangaID}")
    public String createFavorite(Principal principal, @PathVariable(required=true, name="mangaID") Long mangaID){
        favoriteService.saveFavorite(principal.getName(), mangaID);
        return "redirect:/manga/"+mangaID;
    }

    @GetMapping("/favorito/remover/{mangaID}")
    public String deleteFavorite(Principal principal, @PathVariable(required=true, name="mangaID") Long mangaID){
        favoriteService.deleteFavorite(principal.getName(), mangaID);
        return "redirect:/manga/"+mangaID;
    }
}
