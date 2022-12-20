package br.com.mangahub.controllers;
import br.com.mangahub.interfaces.RoleRepositoryInterface;
import br.com.mangahub.interfaces.UserRepositoryInterface;
import br.com.mangahub.models.Users;
import br.com.mangahub.models.filters.UsersFilter;
import br.com.mangahub.services.RelatorioService;
import br.com.mangahub.services.UserService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminUserController {
    @Autowired
    private RoleRepositoryInterface roleRepository;
    
    @Autowired
    private UserRepositoryInterface userRepository;

    @Autowired
    private UserService userService;

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
    public String redirectAdminRegisterUser(Model model, Users user, BindingResult result){
        model.addAttribute("roles", roleRepository.findAll());
        model.addAttribute("errors", result);
        model.addAttribute("user", user);

        return "admin/usuario/registrarUsuario";
    }

    @GetMapping("/admin/usuario/atualizar/{userID}")
    public String redirectAdminUpdateUser(@PathVariable(required=true, name="userID") Long userID, Model model, Users user){
        model.addAttribute("roles", roleRepository.findAll());
        model.addAttribute("user", userRepository.findOneByIdAndDeletedAtIsNull(userID));

        return "admin/usuario/atualizarUsuario";
    }

    @GetMapping("/admin/usuario/deletar/{userID}")
    public String deleteUser(@PathVariable(required=true, name="userID") Long userID){
        userRepository.deleteById(userID);

        return "redirect:/admin/usuarios";
    }

    @PostMapping("/admin/usuario/registrar")
    public String registerUser(@Valid Users user, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("errors", result);
            model.addAttribute("user", user);

            return "admin/usuario/registrarUsuario";
        }
        userService.saveUser(user);
        
        return "redirect:/admin/usuarios";
    }

    @PostMapping("/admin/usuario/atualizar/{userID}")
    public String updateUser(@PathVariable(required=true, name="userID") Long userID, Users user){
        user.setId(userID);
        userService.saveUser(user);
        
        return "redirect:/admin/usuarios";
    }

    @Autowired
	private RelatorioService relatorioService;
	
    
	@GetMapping("/admin/relatorio/favoritos")
	public ResponseEntity<byte[]> gerarRelatorioFavoritos() {
		
		byte[] relatorio = relatorioService.gerarRelatorioFavoritos();
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_PDF_VALUE)
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=relatorioFavoritos.pdf")
				.body(relatorio);
	}
}
