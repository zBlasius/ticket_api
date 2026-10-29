package com.main.ticket_api.session_management.application;

import com.main.ticket_api.session_management.domain.Movie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListMoviesUseCase {
    private final MovieRepository movieRepository;

    public ListMoviesUseCase(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> execute() {
        return movieRepository.findAll();
    }
}
