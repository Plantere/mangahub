package br.com.mangahub.interfaces;

import br.com.mangahub.models.Favorites;
import br.com.mangahub.models.Users;

import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface FavoriteRepositoryInterface extends PagingAndSortingRepository<Favorites, Long> {
    Page<Favorites> findAllByUserAndDeletedAtIsNull(Users user, Pageable pageable);
}
