package com.filmfest.film.service.impl;

import com.filmfest.film.dto.FilmUrlDto;
import com.filmfest.film.mapper.FilmUrlMapper;
import com.filmfest.film.model.FilmUrl;
import com.filmfest.film.repository.FilmUrlRepository;
import com.filmfest.film.service.FilmUrlService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class FilmUrlServiceImpl implements FilmUrlService {

    private final FilmUrlRepository filmUrlRepository;

    @Override
    public Mono<FilmUrlDto> save(FilmUrlDto filmUrlDto) {
        FilmUrl entity = FilmUrlMapper.toEntity(filmUrlDto);
        return filmUrlRepository.save(entity)
                .map(FilmUrlMapper::toDto);
    }

    @Override
    public Flux<FilmUrlDto> findAll() {
        return filmUrlRepository.findAll()
                .map(FilmUrlMapper::toDto);
    }
}
