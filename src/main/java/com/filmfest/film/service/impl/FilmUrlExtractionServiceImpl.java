package com.filmfest.film.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.filmfest.film.dto.FilmUrlDto;
import com.filmfest.film.service.FilmUrlExtractionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class FilmUrlExtractionServiceImpl implements FilmUrlExtractionService {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private static final String BASE_URL = "https://sitgesfilmfestival.com";


    @Override
    public Flux<FilmUrlDto> extractFilmUrls(String rawJson) {
        try {
            JsonNode root = objectMapper.readTree(rawJson);
            List<FilmUrlDto> filmUrlList = new ArrayList<>();

            for (JsonNode node : root) {
                String urlCa = node.path("url_ca").asText();
                String urlEs = node.path("url_es").asText();
                String urlEn = node.path("url_en").asText();

                filmUrlList.add(FilmUrlDto.builder()
                        .fullUrlCa(BASE_URL + "/ca/film/" + urlCa)
                        .fullUrlEs(BASE_URL + "/es/film/" + urlEs)
                        .fullUrlEn(BASE_URL + "/en/film/" + urlEn)
                        .build());
            }

            return Flux.fromIterable(filmUrlList);

        } catch (Exception e) {
            log.error("Failed to parse film URLs", e);
            return Flux.error(e);
        }
    }
}
