package com.main.ticket_api.session_management.infrastructure;

import com.main.ticket_api.session_management.domain.Movie;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

@Entity(name = "Movie") // Keeps the existing "movie" table and "movie_seq" sequence
public class MovieJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @JoinColumn(name = "author_id", nullable = false)
    @ManyToOne
    private AuthorJpaEntity author;

    private Movie.Category category;

    private LocalDateTime releaseDate;

    private Integer duration;

    protected MovieJpaEntity() {
    }

    private MovieJpaEntity(Integer id, String name, AuthorJpaEntity author, Movie.Category category, LocalDateTime releaseDate, Integer duration) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.category = category;
        this.releaseDate = releaseDate;
        this.duration = duration;
    }

    public static MovieJpaEntity fromDomain(Movie movie, AuthorJpaEntity author) {
        return new MovieJpaEntity(movie.getId(), movie.getName(), author, movie.getCategory(), movie.getReleaseDate(), movie.getDuration());
    }

    public Movie toDomain() {
        return new Movie(id, name, author.toDomain(), category, releaseDate, duration);
    }
}
