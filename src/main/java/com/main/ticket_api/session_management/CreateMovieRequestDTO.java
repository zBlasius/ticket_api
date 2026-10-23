package com.main.ticket_api.session_management;

import java.sql.Timestamp;

public class CreateMovieRequestDTO {
    private String name;
    private Integer author_id;
    private Integer duration;

    public Timestamp getRelease_date() {
        return release_date;
    }

    public void setRelease_date(Timestamp release_date) {
        this.release_date = release_date;
    }

    private Timestamp release_date;

    public Movie.Category getCategory() {
        return category;
    }

    public void setCategory(Movie.Category category) {
        this.category = category;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(Integer author_id) {
        this.author_id = author_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private Movie.Category category;
}
