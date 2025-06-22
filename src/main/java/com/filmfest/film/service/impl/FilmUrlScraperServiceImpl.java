package com.filmfest.film.service.impl;

import com.filmfest.film.service.FilmUrlScraperService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class FilmUrlScraperServiceImpl implements FilmUrlScraperService {

    private static final String BASE_URL = "https://sitgesfilmfestival.com";
    private static final String BASE_ENDPOINT = BASE_URL + "/service/films/";

    private final WebClient sitgesWebClient;

    @Override
    public Flux<String> scrapeRawJson(int year) {
        return sitgesWebClient.get()
                .uri(BASE_ENDPOINT)
                .retrieve()
                .bodyToMono(String.class)
                .flatMapMany(json -> Flux.just(json));
    }
}