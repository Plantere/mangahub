package br.com.mangahub.interfaces;

import br.com.mangahub.models.Chapters;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChapterRepositoryInterface extends JpaRepository<Chapters, Long> {
    
    Page<Chapters> findTop10ByOrderByCreatedAt(Pageable pageable);
}
