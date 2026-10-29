package com.main.ticket_api.session_management.application;

import com.main.ticket_api.session_management.domain.Author;
import com.main.ticket_api.session_management.domain.AuthorNotFoundException;
import com.main.ticket_api.session_management.domain.Movie;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class CreateMovieUseCase {
    private final MovieRepository movieRepository;
    private final AuthorRepository authorRepository;

    public CreateMovieUseCase(MovieRepository movieRepository, AuthorRepository authorRepository) {
        this.movieRepository = movieRepository;
        this.authorRepository = authorRepository;
    }

    public record Command(String name, Integer authorId, Movie.Category category, LocalDateTime releaseDate, Integer duration) {
    }

    @Transactional
    public Movie execute(Command command) {
        Author author = authorRepository.findById(command.authorId())
                .orElseThrow(() -> new AuthorNotFoundException(command.authorId()));

        Movie movie = Movie.create(command.name(), author, command.category(), command.releaseDate(), command.duration());
        return movieRepository.save(movie);
    }
}
