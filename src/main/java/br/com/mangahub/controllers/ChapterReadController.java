package br.com.mangahub.controllers;
import br.com.mangahub.interfaces.ChapterReadRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ChapterReadController {
    @Autowired
    private ChapterReadRepositoryInterface chapterReadRepository;
}
