package com.filmfest.film.repository;

import com.filmfest.film.model.entity.FilmUrl;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface FilmUrlRepository extends ReactiveMongoRepository<FilmUrl, String> {
}