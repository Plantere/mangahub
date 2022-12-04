package br.com.mangahub.controllers;
import br.com.mangahub.interfaces.RatingRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class RatingController {
    @Autowired
    private RatingRepositoryInterface ratingRepository;
}
