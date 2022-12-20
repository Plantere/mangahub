package br.com.mangahub.services;

import br.com.mangahub.interfaces.RoleRepositoryInterface;
import br.com.mangahub.interfaces.RoleUserRepositoryInterface;
import br.com.mangahub.interfaces.UserRepositoryInterface;
import br.com.mangahub.models.RolesUsers;
import br.com.mangahub.models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepositoryInterface userRepository;

    @Autowired
    private RoleUserRepositoryInterface roleUserRepository;

    @Autowired
    private RoleRepositoryInterface roleRepository;

    public boolean saveUser(Users user){
        String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12));
        user.setPassword(hashedPassword);
        
        userRepository.save(user);
        return true;
    }

    public boolean updateUser(String userEmail, Users user){
        Users findedUser = userRepository.findOneByEmailAndDeletedAtIsNull(userEmail);
        user.setId(findedUser.getId());
        
        String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12));
        user.setPassword(hashedPassword);
        
        userRepository.save(user);

        return true;
    }


    public Page<Users> findAllByDeletedAtIsNull(Integer page){
        return userRepository.findAllByDeletedAtIsNull(PageRequest.of(page, 15));
    }
}
