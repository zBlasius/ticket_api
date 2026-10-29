package com.main.ticket_api.session_management.application;

import com.main.ticket_api.session_management.domain.Movie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindMoviesUseCase {
    private final MovieRepository movieRepository;

    public FindMoviesUseCase(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> execute(Movie.Category category, Integer authorId) {
        return movieRepository.findByCategoryAndAuthorId(category, authorId);
    }
}
