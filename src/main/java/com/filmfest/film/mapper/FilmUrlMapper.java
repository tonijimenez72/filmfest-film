package com.filmfest.film.mapper;

import com.filmfest.film.dto.FilmUrlDto;
import com.filmfest.film.model.FilmUrl;

public class FilmUrlMapper {
    public static FilmUrlDto toDto(FilmUrl entity) {
        if (entity == null) return null;

        return FilmUrlDto.builder()
                .id(entity.getId())
                .fullUrlCa(entity.getFullUrlCa())
                .fullUrlEs(entity.getFullUrlEs())
                .fullUrlEn(entity.getFullUrlEn())
                .build();
    }

    public static FilmUrl toEntity(FilmUrlDto dto) {
        if (dto == null) return null;

        return FilmUrl.builder()
                .id(dto.getId())
                .fullUrlCa(dto.getFullUrlCa())
                .fullUrlEs(dto.getFullUrlEs())
                .fullUrlEn(dto.getFullUrlEn())
                .build();
    }
}
