package com.main.ticket_api.session_management.web;

import com.main.ticket_api.session_management.domain.Movie;

import java.sql.Timestamp;

public record MovieResponseDTO(
        Integer id,
        String name,
        AuthorDetailResponseDTO author,
        Movie.Category category,
        Timestamp releaseDate,
        Integer duration) {

    public static MovieResponseDTO from(Movie movie) {
        return new MovieResponseDTO(
                movie.getId(),
                movie.getName(),
                AuthorDetailResponseDTO.from(movie.getAuthor()),
                movie.getCategory(),
                movie.getReleaseDate() == null ? null : Timestamp.valueOf(movie.getReleaseDate()),
                movie.getDuration());
    }
}
