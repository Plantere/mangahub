package br.com.mangahub.controllers;
import br.com.mangahub.interfaces.FavoriteRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class FavoriteController {
    @Autowired
    private FavoriteRepositoryInterface favoriteRepository;
}
