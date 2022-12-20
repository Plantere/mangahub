package br.com.mangahub.models;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "mangas")
public class Mangas implements Serializable{
    private static final long serialVersionUID = 4;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "O nome do manga é obrigatorio")
    @Column(name = "name")
    private String mangaName;

    @NotBlank(message = "O descrição é obrigatoria")
    @Column(name = "description")
    private String mangaDescription;

    @NotNull(message = "A faixa etaria é obrigatoria")
    @Column(name = "age_group")
    private Long ageGroup;

    @Column(name = "cover")
    @Type(type="org.hibernate.type.BinaryType")
    @Basic(fetch = FetchType.LAZY)
    private byte[] mangaCover;
    
    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;
    
    @NotNull(message = "A data de lançamento é obrigatoria")
    @Column(name = "released_at")
    @DateTimeFormat(pattern = "yyyy-MM-dd H:m:s")
    private LocalDateTime releasedAt;

    @Column(name = "created_at", updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy= "manga", fetch=FetchType.EAGER)
    @OrderBy("chapterNumber")
    @Where(clause="deleted_at is null")
    private Collection<Chapters> chapters;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMangaName() {
        return mangaName;
    }

    public void setMangaName(String mangaName) {
        this.mangaName = mangaName;
    }

    public String getMangaDescription() {
        return mangaDescription;
    }

    public void setMangaDescription(String mangaDescription) {
        this.mangaDescription = mangaDescription;
    }

    public Long getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(Long ageGroup) {
        this.ageGroup = ageGroup;
    }

    public byte[] getMangaCover() {
        return mangaCover;
    }

    public void setMangaCover(byte[] mangaCover) {
        this.mangaCover = mangaCover;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }

    public LocalDateTime getReleasedAt() {
        return releasedAt;
    }

    public void setReleasedAt(LocalDateTime releasedAt) {
        this.releasedAt = releasedAt;
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

    public Collection<Chapters> getChapters() {
        return chapters;
    }

    public void setChapters(Collection<Chapters> chapters) {
        this.chapters = chapters;
    }

    public String getImageCoverInBase64(){
        return new String(Base64.getEncoder().encode(this.getMangaCover()));
    }

    public Integer getTotalChapters(){
        Set<Long> totalChapters = new HashSet<>();
        for (Chapters chapter : getChapters()) {
            totalChapters.add(chapter.getId());
        }

        return totalChapters.size();
    }

    public Long getPreviousChapter(Long chapterID){
        Long previousChapter = Long.getLong("0");

        for (Chapters chapter : getChapters()) {
            if(chapter.getId() == chapterID){
                return previousChapter;
            }else if(chapter.getDeletedAt() == null){
                previousChapter = chapter.getId();
            }
        }

        return previousChapter;
    }

    public Long getNextChapter(Long chapterID){
        Boolean flag = false;

        for (Chapters chapter : getChapters()) {
            if(chapter.getId() == chapterID){
                flag = true;
                continue;
            }

            if(chapter.getDeletedAt() == null && flag){
                return chapter.getId();
            }
        }

        return Long.getLong("0");
    }
}
