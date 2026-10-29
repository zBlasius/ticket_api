package com.main.ticket_api.session_management.web;

import com.main.ticket_api.session_management.domain.Author;

public record AuthorDetailResponseDTO(Integer id, String name, String origin) {

    public static AuthorDetailResponseDTO from(Author author) { //
        return new AuthorDetailResponseDTO(author.getId(), author.getName(), author.getOrigin());
    }
}
