package br.com.mangahub.interfaces;

import br.com.mangahub.models.ChaptersReads;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ChapterReadRepositoryInterface extends JpaRepository<ChaptersReads, Long>{
    
}
