package br.com.mangahub.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import br.com.mangahub.services.UserService;
import br.com.mangahub.models.Users;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

@Controller
public class AuthController {
    @Autowired
    private UserService userService;

    @GetMapping("/logar")
    public String login(Users user, Model model) {
        model.addAttribute("user", user);
        return "auth/login";
    }

    @GetMapping("/registrar")
    public String register(Users user, Model model, BindingResult result) {
        model.addAttribute("errors", result);
        model.addAttribute("user", user);
        
        return "auth/registrar";
    }

    @PostMapping("/registrar")
    public String createUser(@Valid Users user, BindingResult result, Model model) {
        if(result.hasErrors()){
            model.addAttribute("errors", result);
            model.addAttribute("user", user);
            return "auth/registrar";
        }

        userService.saveUser(user);
        return "redirect:/logar";
    }
}
