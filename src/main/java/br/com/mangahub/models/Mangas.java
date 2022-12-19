package br.com.mangahub.models;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.Collection;

@Entity
@Table(name = "mangas")
public class Mangas implements Serializable{
    private static final long serialVersionUID = 4;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String mangaName;

    @Column(name = "description")
    private String mangaDescription;

    @Column(name = "age_group")
    private int ageGroup;

    @Column(name = "cover")
    @Type(type="org.hibernate.type.BinaryType")
    @Basic(fetch = FetchType.LAZY)
    private byte[] mangaCover;
    
    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

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

    public int getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(int ageGroup) {
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
        return getChapters().size();        
    }

    public Long getPreviousChapter(Long chapterID){
        Long previousChapter = new Long(0);

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

        return new Long(0);
    }
}
