package br.com.mangahub.interfaces;

import br.com.mangahub.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepositoryInterface extends JpaRepository<Users, UUID> {
    Users findOneByEmailAndDeletedAtIsNull(String email);
}
