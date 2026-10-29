package com.main.ticket_api.session_management.domain;

public class AuthorNotFoundException extends RuntimeException {
    public AuthorNotFoundException(Integer authorId) {
        super("Author " + authorId + " not found");
    }
}
