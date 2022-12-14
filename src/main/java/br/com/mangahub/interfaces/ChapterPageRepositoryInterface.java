package br.com.mangahub.interfaces;

import br.com.mangahub.models.ChaptersPages;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ChapterPageRepositoryInterface extends JpaRepository<ChaptersPages, Long>{
    
}
