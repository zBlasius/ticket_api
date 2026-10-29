package com.main.ticket_api.session_management.web;

public class CreateMovieResponseDTO {
    private final Integer movie_id;

    public CreateMovieResponseDTO(Integer movie_id) {
        this.movie_id = movie_id;
    }

    public Integer getMovie_id() {
        return movie_id;
    }
}
