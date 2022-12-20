package br.com.mangahub.models;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;

@Entity
@Table(name = "chapters")

public class Chapters implements Serializable {
    private static final long serialVersionUID = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "manga_id")
    private Mangas manga;

    @OneToMany(mappedBy= "chapter", fetch=FetchType.EAGER)
    private Collection<ChaptersPages> chaptersPages;

    @NotNull(message = "O numero do capitulo é obrigatorio")
    @Min(value=0)
    @Column(name = "number")
    private Long chapterNumber;

    @NotBlank(message = "O titulo é obrigatorio")
    @Column(name = "title")
    private String chapterTitle;
    
    @NotNull(message = "A data de lançamento é obrigatoria")
    @Column(name = "released_at")
    @DateTimeFormat(pattern = "yyyy-MM-dd H:m:s")
    private LocalDateTime releasedAt;

    @Column(name = "deleted_at")
    @DateTimeFormat(pattern = "yyyy-MM-dd H:m:s")
    private LocalDateTime deletedAt;

    @Column(name = "created_at", updatable = false)
    @CreationTimestamp
    @DateTimeFormat(pattern = "yyyy-MM-dd H:m:s")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    @DateTimeFormat(pattern = "yyyy-MM-dd H:m:s")
    private LocalDateTime updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Mangas getManga() {
        return manga;
    }

    public void setManga(Mangas manga) {
        this.manga = manga;
    }

    public Collection<ChaptersPages> getChaptersPages() {
        return chaptersPages;
    }

    public void setChaptersPages(Collection<ChaptersPages> chaptersPages) {
        this.chaptersPages = chaptersPages;
    }

    public Long getChapterNumber() {
        return chapterNumber;
    }

    public void setChapterNumber(Long chapterNumber) {
        this.chapterNumber = chapterNumber;
    }

    public String getChapterTitle() {
        return chapterTitle;
    }

    public void setChapterTitle(String chapterTitle) {
        this.chapterTitle = chapterTitle;
    }

    public LocalDateTime getReleasedAt() {
        return releasedAt;
    }

    public void setReleasedAt(LocalDateTime releasedAt) {
        this.releasedAt = releasedAt;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
