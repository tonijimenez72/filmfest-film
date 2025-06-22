package com.filmfest.film.service;

import com.filmfest.film.dto.FilmUrlDto;
import reactor.core.publisher.Flux;

public interface FilmUrlExtractionService {
    Flux<FilmUrlDto> extractFilmUrls(String rawJson);
}
