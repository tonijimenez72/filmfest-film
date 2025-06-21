package com.filmfest.film.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FilmUrlDto {
    private String id;

    private String fullUrlCa;
    private String fullUrlEn;
    private String fullUrlEs;
}