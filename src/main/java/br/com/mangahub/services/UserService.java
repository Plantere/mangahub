package br.com.mangahub.services;

import br.com.mangahub.interfaces.UserRepositoryInterface;
import br.com.mangahub.models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepositoryInterface userRepository;

    public boolean saveUser(Users user){
        String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12));
        user.setPassword(hashedPassword);

        userRepository.save(user);

        return true;
    }
}
