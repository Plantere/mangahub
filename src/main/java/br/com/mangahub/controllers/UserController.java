package br.com.mangahub.controllers;
import br.com.mangahub.interfaces.RoleRepositoryInterface;
import br.com.mangahub.interfaces.UserRepositoryInterface;
import br.com.mangahub.models.Users;
import br.com.mangahub.models.filters.UsersFilter;
import br.com.mangahub.services.UserService;

import java.security.Principal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    @Autowired
    private UserRepositoryInterface userRepository;

    @Autowired
    private RoleRepositoryInterface roleRepository;


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

    @GetMapping("/admin/usuarios")
    public String getAllUsers(UsersFilter filtro, Model model, @PageableDefault(size = 15) @SortDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable, HttpServletRequest request){
        
		Page<Users> usersPage = userRepository.pesquisar(filtro, pageable);

		model.addAttribute("users", usersPage);
        
        int totalPages = usersPage.getTotalPages();
        List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                                            .boxed()
                                            .collect(Collectors.toList());
        
        model.addAttribute("pageNumbers", pageNumbers);

        return "admin/mostrarUsuarios";
    }

    @GetMapping("/admin/usuario/registrar")
    public String redirectAdminRegisterUser(Model model, Users user){
        model.addAttribute("roles", roleRepository.findAll());
        model.addAttribute("user", user);

        return "admin/usuario/registrarUsuario";
    }

    @PostMapping("/admin/usuario/registrar")
    public String registerUser(Users user){
        userService.saveUser(user);
        
        return "redirect:/admin/usuarios";
    }

    @GetMapping("/admin/usuario/{userID}/atualizar")
    public String redirectAdminUpdateUser(@PathVariable(required=true, name="userID") UUID userID, Model model, Users user){
        model.addAttribute("roles", roleRepository.findAll());
        model.addAttribute("user", userRepository.findOneByIdAndDeletedAtIsNull(userID));

        return "admin/usuario/atualizarUsuario";
    }

    @PostMapping("/admin/usuario/{userID}/atualizar")
    public String updateUser(@PathVariable(required=true, name="userID") UUID userID, Users user){
        user.setId(userID);
        userService.saveUser(user);
        
        return "redirect:/admin/usuarios";
    }

    @GetMapping("/admin/usuario/{userID}/deletar")
    public String deleteUser(@PathVariable(required=true, name="userID") UUID userID){
        userRepository.deleteById(userID);

        return "redirect:/admin/usuarios";
    }
}
