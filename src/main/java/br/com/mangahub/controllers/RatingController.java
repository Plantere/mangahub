package br.com.mangahub.controllers;
import br.com.mangahub.interfaces.RatingRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RatingController {
    @Autowired
    private RatingRepositoryInterface ratingRepository;

    @GetMapping("/teste/usuario")
    public String fbi(){
        return "test_login";
    }
}
