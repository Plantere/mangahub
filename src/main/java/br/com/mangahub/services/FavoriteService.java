package br.com.mangahub.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.mangahub.interfaces.FavoriteRepositoryInterface;
import br.com.mangahub.interfaces.MangaRepositoryInterface;
import br.com.mangahub.interfaces.UserRepositoryInterface;
import br.com.mangahub.models.Favorites;
import br.com.mangahub.models.Mangas;
import br.com.mangahub.models.Users;

@Service
public class FavoriteService {
    @Autowired
    private FavoriteRepositoryInterface favoriteRepository;

    @Autowired
    private UserRepositoryInterface userRepository;
    
    @Autowired
    private MangaRepositoryInterface mangaRepository;

    public Page<Favorites> findAllByUserAndDeletedAtIsNull(Users user, Integer page){
        return favoriteRepository.findAllByUserAndDeletedAtIsNull(user, PageRequest.of(page, 10));
    }

    public Boolean saveFavorite(String userEmail, Long mangaID){
        Favorites favorite = new Favorites();

        favorite.setManga(mangaRepository.findOneByIdAndDeletedAtIsNull(mangaID));
        favorite.setUser(userRepository.findOneByEmailAndDeletedAtIsNull(userEmail));

        favoriteRepository.save(favorite);
        
        return true;
    }

    public Boolean deleteFavorite(String userEmail, Long mangaID){
        Mangas manga = mangaRepository.findOneByIdAndDeletedAtIsNull(mangaID);
        Users user = userRepository.findOneByEmailAndDeletedAtIsNull(userEmail);
        
        favoriteRepository.deleteByMangaAndUser(manga, user);

        return true;
    }
}
