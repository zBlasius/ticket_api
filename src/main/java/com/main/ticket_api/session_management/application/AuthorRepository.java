package com.main.ticket_api.session_management.application;

import com.main.ticket_api.session_management.domain.Author;

import java.util.List;
import java.util.Optional;

// Port: implemented by the infrastructure layer
public interface AuthorRepository {
    Author save(Author author);

    List<Author> findAll();

    Optional<Author> findById(Integer id);
}
