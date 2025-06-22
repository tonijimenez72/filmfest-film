package com.filmfest.film.service;

import com.filmfest.film.dto.FilmUrlDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface FilmUrlService {
    Mono<FilmUrlDto> save(FilmUrlDto filmUrlDto);
    Flux<FilmUrlDto> findAll();
}
