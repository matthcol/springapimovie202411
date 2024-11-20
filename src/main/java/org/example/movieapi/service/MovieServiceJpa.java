package org.example.movieapi.service;

import org.example.movieapi.dto.MovieDtoCreate;
import org.example.movieapi.dto.MovieDtoDetail;
import org.example.movieapi.dto.MovieDtoSimple;
import org.example.movieapi.entity.Movie;
import org.example.movieapi.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Profile("jpa")
@Service
public class MovieServiceJpa implements MovieService{

    @Autowired
    private MovieRepository movieRepository;


    @Override
    public MovieDtoSimple add(MovieDtoCreate movieDto) {
        var movieEntity = Movie.builder()
                .title(movieDto.getTitle())
                .year(movieDto.getYear())
                .build();
        movieRepository.saveAndFlush(movieEntity);
        return MovieDtoSimple.builder()
                .id(movieEntity.getId())
                .title(movieEntity.getTitle())
                .year(movieEntity.getYear())
                .build();
    }

    @Override
    public Optional<MovieDtoDetail> getById(int id) {
        return Optional.empty();
    }

    @Override
    public List<MovieDtoSimple> getAll() {
        return List.of();
    }

    @Override
    public MovieDtoSimple update(MovieDtoSimple movieDto) {
        return null;
    }

    @Override
    public Optional<MovieDtoDetail> setDirector(int movieId, int directorId) {
        return Optional.empty();
    }

    @Override
    public Optional<MovieDtoDetail> setActors(int movieId, List<Integer> actorIds) {
        return Optional.empty();
    }
}
