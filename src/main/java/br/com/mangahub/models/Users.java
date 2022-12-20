package br.com.mangahub.models;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.UUID;

@Entity
@Table(name = "users")
public class Users implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "VARCHAR(255)")
    private UUID id;

    @OneToMany(mappedBy = "user", fetch=FetchType.EAGER)
    private Collection<Favorites> favorites;
    
    @NotBlank(message = "O E-mail é obrigatorio")
    @Email(message="O e-mail informado não consta num formato valido")
    @Column(name = "email")
    private String email;

    @NotBlank(message = "A senha é obrigatoria")
    @Column(name = "password")
    private String password;

    @NotBlank(message = "O Nome é obrigatorio")
    @Column(name = "name")
    private String name;

    @Column(name = "status")
    private Long status = Long.valueOf(1);

    @Column(name = "role")
    private Long role = null;

    @Column(name = "deleted_at")
    @DateTimeFormat(pattern = "yyyy-MM-dd H:m:s")
    private LocalDateTime deletedAt;

    @Column(name="created_at", updatable = false)
    @CreationTimestamp
    @DateTimeFormat(pattern = "yyyy-MM-dd H:m:s")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    @DateTimeFormat(pattern = "yyyy-MM-dd H:m:s")
    private LocalDateTime updatedAt;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public void setRole(Long role) {
        this.role = role;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Long getStatus() {
        return status;
    }

    public Long getRole() {
        return role;
    }

    public String getPassword() {
        return password;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public String obterDataDeCriacao(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return getCreatedAt().format(formatter);

    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public Collection<Favorites> getFavorites() {
        return favorites;
    }

    public void setFavorites(Collection<Favorites> favorites) {
        this.favorites = favorites;
    }

    public Boolean isFavorited(Long mangaID){
        for (Favorites favorite : getFavorites()) {
            if(favorite.getDeletedAt() == null && favorite.getManga().getId() == mangaID){
                return true;
            }
        }

        return false;
    }
}
