package com.nguyenbinh.identity_service.service;


import com.nguyenbinh.identity_service.dto.request.MovieCreationRequest;
import com.nguyenbinh.identity_service.entity.Movie;
import com.nguyenbinh.identity_service.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public Movie createMovie(MovieCreationRequest request){
        Movie Movie= new Movie();

        Movie.setTitle(request.getTitle());
        Movie.setDescription(request.getDescription());
        Movie.setAge_rating(request.getAge_rating());
        Movie.setType(request.getType());
        Movie.setDirector(request.getDirector());
        Movie.setActor(request.getActor());
        Movie.setCategory(request.getCategory());
        Movie.setLength(request.getLength());
        Movie.setRelease_date(request.getRelease_date());
        Movie.setLanguage(request.getLanguage());
        Movie.setLink(request.getLink());
        Movie.setPrice(request.getPrice());
        Movie.setFavourite(request.getFavourite());

        return movieRepository.save(Movie);
    }

}
