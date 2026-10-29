package com.main.ticket_api.session_management.application;

import com.main.ticket_api.session_management.domain.Movie;

import java.util.List;

// Port: implemented by the infrastructure layer
public interface MovieRepository {
    Movie save(Movie movie);

    List<Movie> findAll();

    List<Movie> findByCategoryAndAuthorId(Movie.Category category, Integer authorId);
}
