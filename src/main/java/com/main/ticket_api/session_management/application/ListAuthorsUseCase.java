package com.main.ticket_api.session_management.application;

import com.main.ticket_api.session_management.domain.Author;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListAuthorsUseCase {
    private final AuthorRepository authorRepository;

    public ListAuthorsUseCase(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> execute() {
        return authorRepository.findAll();
    }
}
