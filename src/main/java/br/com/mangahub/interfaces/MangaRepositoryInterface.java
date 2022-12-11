package br.com.mangahub.interfaces;

import br.com.mangahub.models.Mangas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MangaRepositoryInterface extends JpaRepository<Mangas, Long> {
}
