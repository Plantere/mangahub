package br.com.mangahub.interfaces;

import br.com.mangahub.models.Users;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

import javax.transaction.Transactional;

public interface UserRepositoryInterface extends JpaRepository<Users, UUID> {
    Users findOneByEmailAndDeletedAtIsNull(String email);
    Users findOneByIdAndDeletedAtIsNull(UUID id);

    Page<Users> findAllByDeletedAtIsNull(Pageable page);
    

    @Query("update #{#entityName} e set e.deletedAt = now() where e.id = ?1")
    @Transactional
    @Modifying
    void deleteById(UUID id);
}
