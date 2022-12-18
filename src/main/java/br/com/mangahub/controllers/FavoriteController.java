package br.com.mangahub.controllers;
import br.com.mangahub.interfaces.FavoriteRepositoryInterface;
import br.com.mangahub.interfaces.UserRepositoryInterface;
import br.com.mangahub.models.Favorites;
import br.com.mangahub.models.Users;
import br.com.mangahub.services.FavoriteService;

import java.security.Principal;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FavoriteController {
    @Autowired
    private FavoriteRepositoryInterface favoriteRepository;

    @Autowired
    private UserRepositoryInterface userRepository;

    @Autowired
    private FavoriteService favoriteService;

    @GetMapping("/favorito")
    public String getFavorites(@RequestParam(defaultValue = "0") String page, Model model, Principal principal){
        Users user = userRepository.findOneByEmailAndDeletedAtIsNull(principal.getName());

        model.addAttribute("favorites", favoriteService.findAllByUserAndDeletedAtIsNull(user, Integer.parseInt(page)));
        
        return "favoritos/mostrarFavoritos";
    }
    
    @GetMapping("/favorito/adicionar")
    public String createFavorites(Principal principal, Favorites favorites){
        Users user = userRepository.findOneByEmailAndDeletedAtIsNull(principal.getName());
        favorites.setUser(user);

        favoriteService.saveFavorite(favorites);

        return "index";
    }
}
