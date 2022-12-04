package br.com.mangahub.services;

import org.springframework.stereotype.Service;

import br.com.mangahub.models.Users;

@Service
public class AuthService {
    public boolean loginUser(Users user){
        return true;
    }
}
