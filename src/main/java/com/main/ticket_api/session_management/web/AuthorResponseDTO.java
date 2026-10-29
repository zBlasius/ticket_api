package com.main.ticket_api.session_management.web;

import com.main.ticket_api.session_management.domain.Author;

public class AuthorResponseDTO {

    private Integer author_id;
    private String name;
    private String origin;

    public AuthorResponseDTO(Author author) {
        this.author_id = author.getId();
        this.name = author.getName();
        this.origin = author.getOrigin();
    }

    public Integer getAuthor_id() {
        return author_id;
    }

    public String getName() {
        return name;
    }

    public String getOrigin() {
        return origin;
    }
}