package br.com.mangahub.interfaces;

import br.com.mangahub.models.Favorites;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteRepositoryInterface extends JpaRepository<Favorites, Long> {
}
