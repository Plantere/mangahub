package br.com.mangahub.interfaces;

import br.com.mangahub.models.Chapters;
import br.com.mangahub.models.ChaptersPages;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface ChapterPageRepositoryInterface extends JpaRepository<ChaptersPages, Long>{
    @Override
    @Transactional(readOnly = true)
    @Query("select e from #{#entityName} e where e.deletedAt is null and e.id = ?1")
    Optional<ChaptersPages> findById(Long id);
    
    @Override
    @Transactional(readOnly = true)
    @Query("select e from #{#entityName} e where e.id = ?1 and e.deletedAt is null")
    ChaptersPages getOne(Long id);

    @Override
    @Transactional(readOnly = true)
    default boolean existsById(Long id) {
        return getOne(id) != null;
    }

    @Query("select e from #{#entityName} e where e.chapter.id = ?1 and e.page = ?2 and deletedAt is null")
    Optional<ChaptersPages> findByChapterIdAndPage(Long chapterID, int pageNumber);
    
    @Query("select e from #{#entityName} e where e.chapter.id = ?1 and e.deletedAt is null")
    Optional<ChaptersPages> findByChapterIdAndDeletedAtIsNull(Long chapterID);

    @Modifying
    @Transactional
    @Query("update #{#entityName} e set e.deletedAt = now() where e.chapter.id = ?1 and e.page = ?2 and e.deletedAt is null")
    void deleteByChapterIdAndPage(Long chapterID, int pageNumber);

    @Modifying
    @Transactional
    @Query("update #{#entityName} e set e.deletedAt = now() where e.chapter.id = ?1 and e.deletedAt is null")
    void deleteByChapterId(Long chapterID);

    @Modifying
    @Transactional
    @Query("update #{#entityName} e set e.deletedAt = now() where e.chapter.manga.id = ?1 and e.deletedAt is null")
    void deleteByMangaId(Long mangaID);
}
