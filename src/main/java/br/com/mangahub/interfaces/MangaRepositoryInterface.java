package br.com.mangahub.interfaces;

import br.com.mangahub.models.Mangas;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Pageable;
@Repository
public interface MangaRepositoryInterface extends PagingAndSortingRepository<Mangas, Long> {
    @Override
    @Transactional(readOnly = true)
    @Query("select e from #{#entityName} e where e.deletedAt is null and e.id = ?1")
    Optional<Mangas> findById(Long id);

    Page<Mangas> findAllByDeletedAtIsNull(Pageable pageable);

    Mangas findOneByIdAndDeletedAtIsNull(Long id);

    @Query("update #{#entityName} e set e.deletedAt = now() where e.id = ?1")
    @Transactional
    @Modifying
    void deleteById(Long id);
}
