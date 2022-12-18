package br.com.mangahub.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.mangahub.interfaces.FavoriteRepositoryInterface;
import br.com.mangahub.models.Favorites;
import br.com.mangahub.models.Users;

@Service
public class FavoriteService {
    @Autowired
    private FavoriteRepositoryInterface favoriteRepository;

    public Page<Favorites> findAllByUserAndDeletedAtIsNull(Users user, Integer page){
        return favoriteRepository.findAllByUserAndDeletedAtIsNull(user, PageRequest.of(page, 10));
    }

    public Boolean saveFavorite(Favorites favorite){
        favoriteRepository.save(favorite);
        return true;
    }
}
