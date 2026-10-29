package com.main.ticket_api.session_management.application;

import com.main.ticket_api.session_management.domain.Author;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreateAuthorUseCase {
    private final AuthorRepository authorRepository;

    public CreateAuthorUseCase(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Transactional // It's a notation for a database transaction, if an error happens a rollback will be runned
    public Author execute(String name, String origin) {
        return authorRepository.save(Author.create(name, origin));
    }

    // if I didn't put transaction, I would need something like this:
    /*

begin transaction
try {
    result = myMethod();   // authorRepository.save(...)
    commit
    return result;
} catch (RuntimeException e) {
    rollback
    throw e;
}
    * */
}
