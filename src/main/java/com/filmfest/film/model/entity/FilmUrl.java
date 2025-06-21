package com.filmfest.film.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "film_urls")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FilmUrl {
    @Id
    private String id;

    private String fullUrlCa;
    private String fullUrlEs;
    private String fullUrlEn;
}