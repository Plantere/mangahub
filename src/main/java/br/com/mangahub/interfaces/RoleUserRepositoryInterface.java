package br.com.mangahub.interfaces;

import br.com.mangahub.models.RolesUsers;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleUserRepositoryInterface extends JpaRepository<RolesUsers, Long> {
}
