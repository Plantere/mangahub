package br.com.mangahub.interfaces;

import br.com.mangahub.interfaces.queries.UserQueries;
import br.com.mangahub.models.Users;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface UserRepositoryInterface extends JpaRepository<Users, Long>, UserQueries {
    Users findOneByEmailAndDeletedAtIsNull(String email);
    Users findOneByIdAndDeletedAtIsNull(Long id);

    Page<Users> findAllByDeletedAtIsNull(Pageable page);
    

    @Query("update #{#entityName} e set e.deletedAt = now() where e.id = ?1")
    @Transactional
    @Modifying
    void deleteById(Long id);
}
