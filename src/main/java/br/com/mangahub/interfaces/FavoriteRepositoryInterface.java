package br.com.mangahub.interfaces;

import br.com.mangahub.models.Favorites;
import br.com.mangahub.models.Mangas;
import br.com.mangahub.models.Users;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;

import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface FavoriteRepositoryInterface extends PagingAndSortingRepository<Favorites, Long> {
    Page<Favorites> findAllByUserAndDeletedAtIsNull(Users user, Pageable pageable);

    Favorites findOneByUserAndManga(Users user, Mangas manga);

    @Modifying
    @Transactional
    @Query("update #{#entityName} e set e.deletedAt = now() where e.manga = ?1 and e.user = ?2 and e.deletedAt is null")
    void deleteByMangaAndUser(Mangas manga, Users user);

    @Modifying
    @Transactional
    @Query("update #{#entityName} e set e.deletedAt = now() where e.manga.id = ?1 and e.deletedAt is null")
    void deleteByMangaId(Long mangaID);
}
