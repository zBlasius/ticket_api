package com.main.ticket_api.session_management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

interface IAuthorService {
    public Author create(CreateAuthorRequestDTO request);
    public List<Author> findAll();
    public Author findOne(Integer author_id);
}

@Service
public class AuthorService implements IAuthorService {
    @Autowired // This means to get the bean called userRepository
    private AuthorRepository authorRepository;

    public Author create(CreateAuthorRequestDTO request) {
        Author author = new Author();
        author.setName(request.getName());
        author.setOrigin(request.getOrigin());
        authorRepository.save(author);
        return author;
    }

    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    public Author findOne(Integer author_id) {
        return authorRepository.findById(author_id).orElse(null);
    }
}
