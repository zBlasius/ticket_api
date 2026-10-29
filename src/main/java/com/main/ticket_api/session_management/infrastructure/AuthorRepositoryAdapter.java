package com.main.ticket_api.session_management.infrastructure;

import com.main.ticket_api.session_management.application.AuthorRepository;
import com.main.ticket_api.session_management.domain.Author;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AuthorRepositoryAdapter implements AuthorRepository {
    private final AuthorJpaRepository authorJpaRepository;

    AuthorRepositoryAdapter(AuthorJpaRepository authorJpaRepository) {
        this.authorJpaRepository = authorJpaRepository;
    }

    @Override
    public Author save(Author author) {
        return authorJpaRepository.save(AuthorJpaEntity.fromDomain(author)).toDomain();
    }

    @Override
    public List<Author> findAll() {
        return authorJpaRepository.findAll().stream()
                .map(AuthorJpaEntity::toDomain)
                .toList();
    }

    @Override
    public Optional<Author> findById(Integer id) {
        return authorJpaRepository.findById(id).map(AuthorJpaEntity::toDomain);
    }
}
