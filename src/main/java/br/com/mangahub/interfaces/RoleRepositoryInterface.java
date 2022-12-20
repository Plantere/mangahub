package br.com.mangahub.interfaces;

import br.com.mangahub.models.Roles;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepositoryInterface extends JpaRepository<Roles, Long> {
    Optional<Roles> findByName(String name);

}
