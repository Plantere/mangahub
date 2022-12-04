package br.com.mangahub.interfaces;

import br.com.mangahub.models.Mangas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MangaRepositoryInterface extends JpaRepository<Mangas, Long> {
}
