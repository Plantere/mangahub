package br.com.mangahub.models.filters;

import java.time.LocalDateTime;

public class UsersFilter {
	private String name;
	private String email;
    
	private LocalDateTime dataCriacaoMaiorQue;
	private LocalDateTime dataCriacaoMenorQue;

    private Long favoritosMaiorQue;
	private Long favoritosMenorQue;
    
	@Override
    public String toString() {
        return "UsersFilter [name=" + name + ", email=" + email + ", dataCriacaoMaiorQue=" + dataCriacaoMaiorQue
                + ", dataCriacaoMenorQue=" + dataCriacaoMenorQue + ", favoritosMaiorQue=" + favoritosMaiorQue
                + ", favoritosMenorQue=" + favoritosMenorQue + "]";
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public LocalDateTime getDataCriacaoMaiorQue() {
        return dataCriacaoMaiorQue;
    }
    public void setDataCriacaoMaiorQue(LocalDateTime dataCriacaoMaiorQue) {
        this.dataCriacaoMaiorQue = dataCriacaoMaiorQue;
    }
    public LocalDateTime getDataCriacaoMenorQue() {
        return dataCriacaoMenorQue;
    }
    public void setDataCriacaoMenorQue(LocalDateTime dataCriacaoMenorQue) {
        this.dataCriacaoMenorQue = dataCriacaoMenorQue;
    }
    public Long getFavoritosMaiorQue() {
        return favoritosMaiorQue;
    }
    public void setFavoritosMaiorQue(Long favoritosMaiorQue) {
        this.favoritosMaiorQue = favoritosMaiorQue;
    }
    public Long getFavoritosMenorQue() {
        return favoritosMenorQue;
    }
    public void setFavoritosMenorQue(Long favoritosMenorQue) {
        this.favoritosMenorQue = favoritosMenorQue;
    }

}
