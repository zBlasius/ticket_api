package com.main.ticket_api.session_management.domain;

import java.time.LocalDateTime;

public class Movie {
    private final Integer id;
    private final String name;
    private final Author author;
    private final Category category;
    private final LocalDateTime releaseDate;
    private final Integer duration;

    public Movie(Integer id, String name, Author author, Category category, LocalDateTime releaseDate, Integer duration) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.category = category;
        this.releaseDate = releaseDate;
        this.duration = duration;
    }

    public static Movie create(String name, Author author, Category category, LocalDateTime releaseDate, Integer duration) {
        return new Movie(null, name, author, category, releaseDate, duration);
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Author getAuthor() {
        return author;
    }

    public Category getCategory() {
        return category;
    }

    public LocalDateTime getReleaseDate() {
        return releaseDate;
    }

    public Integer getDuration() {
        return duration;
    }

    // Persisted by ordinal: only append new values, never reorder
    public enum Category {
        ACTION,
        COMEDY,
        DRAMA,
        HORROR,
        ROMANCE
    }
}
