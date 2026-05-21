package com.piotr.flightsearchapi.service;

import com.piotr.flightsearchapi.domain.CreateFavoriteRequest;
import com.piotr.flightsearchapi.domain.entity.Favorite;

import java.util.List;

public interface FavoriteService {
    List<Favorite> getAllFavorites();
    Favorite createFavorite(CreateFavoriteRequest request);
    void deleteFavorite(Integer id);


}
