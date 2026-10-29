package com.main.ticket_api.session_management.infrastructure;

import com.main.ticket_api.session_management.application.MovieRepository;
import com.main.ticket_api.session_management.domain.Movie;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovieRepositoryAdapter implements MovieRepository {
    private final MovieJpaRepository movieJpaRepository;
    private final AuthorJpaRepository authorJpaRepository;

    MovieRepositoryAdapter(MovieJpaRepository movieJpaRepository, AuthorJpaRepository authorJpaRepository) {
        this.movieJpaRepository = movieJpaRepository;
        this.authorJpaRepository = authorJpaRepository;
    }

    @Override
    public Movie save(Movie movie) {
        AuthorJpaEntity author = authorJpaRepository.getReferenceById(movie.getAuthor().getId());
        return movieJpaRepository.save(MovieJpaEntity.fromDomain(movie, author)).toDomain();
    }

    @Override
    public List<Movie> findAll() {
        return movieJpaRepository.findAll().stream()
                .map(MovieJpaEntity::toDomain)
                .toList();
    }

    @Override
    public List<Movie> findByCategoryAndAuthorId(Movie.Category category, Integer authorId) {
        return movieJpaRepository.findByCategoryAndAuthor_Id(category, authorId).stream()
                .map(MovieJpaEntity::toDomain)
                .toList();
    }
}
