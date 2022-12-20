package br.com.mangahub.controllers;
import br.com.mangahub.interfaces.UserRepositoryInterface;
import br.com.mangahub.models.Users;
import br.com.mangahub.services.UserService;

import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    private UserRepositoryInterface userRepository;

    @Autowired
    private UserService userService;

    @GetMapping("/usuario/editar/perfil")
    public String redirectUpdateProfile(Principal principal, Model model){
        Users user = userRepository.findOneByEmailAndDeletedAtIsNull(principal.getName());
        model.addAttribute("user", user);
        return "usuario/editarPerfil";
    }

    @PostMapping("/usuario/editar/perfil")
    public String updateProfile(Principal principal, Users user){
        userService.updateUser(principal.getName(), user);
        return "redirect:/usuario/editar/perfil";
    }
}
