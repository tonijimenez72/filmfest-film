package com.filmfest.film.service;

import reactor.core.publisher.Flux;

public interface FilmUrlScraperService {
    Flux<String> scrapeRawJson(int year);
}
