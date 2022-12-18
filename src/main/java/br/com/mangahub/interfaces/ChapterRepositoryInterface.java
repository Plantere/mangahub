package br.com.mangahub.interfaces;

import br.com.mangahub.models.Chapters;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface ChapterRepositoryInterface extends JpaRepository<Chapters, Long> {
    @Override
    @Transactional(readOnly = true)
    @Query("select e from #{#entityName} e where e.deletedAt is null and e.id = ?1")
    Optional<Chapters> findById(Long id);

    @Override
    @Transactional(readOnly = true)
    @Query("select e from #{#entityName} e where e.id = ?1 and e.deletedAt is null")
    Chapters getOne(Long id);

    @Override
    @Transactional(readOnly = true)
    default boolean existsById(Long id) {
        return getOne(id) != null;
    }

    @Query("update #{#entityName} e set e.deletedAt = now() where e.id = ?1")
    @Transactional
    @Modifying
    void deleteById(Long id);

    
}
