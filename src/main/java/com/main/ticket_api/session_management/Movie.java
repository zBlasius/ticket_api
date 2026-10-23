package com.main.ticket_api.session_management;

import jakarta.persistence.*;
import org.jspecify.annotations.Nullable;

import java.sql.Timestamp;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @JoinColumn(name = "author_id", nullable = false)
    @ManyToOne(cascade = CascadeType.ALL)
    private Author author;

    private Category category;

    public Timestamp getReleaseDate() {
        return ReleaseDate;
    }

    public void setReleaseDate(Timestamp releaseDate) {
        ReleaseDate = releaseDate;
    }

    private Timestamp ReleaseDate;

    public @Nullable Integer getId() {
        return id;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    private Integer duration;

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public enum Category {
        ACTION,
        COMEDY,
        DRAMA,
        HORROR,
        ROMANCE
    }

}
