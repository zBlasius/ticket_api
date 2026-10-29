package com.main.ticket_api.session_management.application;

import com.main.ticket_api.session_management.domain.Author;
import com.main.ticket_api.session_management.domain.AuthorNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class GetAuthorUseCase {
    private final AuthorRepository authorRepository;

    public GetAuthorUseCase(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author execute(Integer authorId) {
        return authorRepository.findById(authorId)
                .orElseThrow(() -> new AuthorNotFoundException(authorId));
    }
}
