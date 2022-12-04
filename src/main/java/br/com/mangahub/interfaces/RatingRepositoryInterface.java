package br.com.mangahub.interfaces;

import br.com.mangahub.models.Ratings;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepositoryInterface extends JpaRepository<Ratings, Long> {
}
