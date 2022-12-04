package br.com.mangahub.controllers;
import br.com.mangahub.interfaces.UserRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    @Autowired
    private UserRepositoryInterface userRepository;
}
