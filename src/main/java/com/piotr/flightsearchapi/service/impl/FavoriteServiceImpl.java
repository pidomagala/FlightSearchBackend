package com.piotr.flightsearchapi.service.impl;

import com.piotr.flightsearchapi.domain.CreateFavoriteRequest;
import com.piotr.flightsearchapi.domain.entity.Favorite;
import com.piotr.flightsearchapi.repository.FavoriteRepository;
import com.piotr.flightsearchapi.service.FavoriteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteServiceImpl implements FavoriteService {

    private final FavoriteRepository favoriteRepository;

    public FavoriteServiceImpl(FavoriteRepository favoriteRepository) {
        this.favoriteRepository = favoriteRepository;
    }


    @Override
    public List<Favorite> getAllFavorites() {
        return favoriteRepository.findAll();
    }

    @Override
    public Favorite createFavorite(CreateFavoriteRequest request) {
        Favorite favorite = favoriteRepository.findByFlightId(request.FlightId());
        if(!(favorite == null)){
            throw new IllegalArgumentException("Flight with this id already is in your favorites");
        }
        return favoriteRepository.save(new Favorite(null, request.UserId(), request.FlightId()));
    }

    @Override
    public void deleteFavorite(Integer id) {
        favoriteRepository.deleteById(id);
    }
}
