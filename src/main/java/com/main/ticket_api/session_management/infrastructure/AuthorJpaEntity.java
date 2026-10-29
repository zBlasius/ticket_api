package com.main.ticket_api.session_management.infrastructure;

import com.main.ticket_api.session_management.domain.Author;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "Author") // Keeps the existing "author" table and "author_seq" sequence
public class AuthorJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private String origin;

    protected AuthorJpaEntity() {
    }

    private AuthorJpaEntity(Integer id, String name, String origin) {
        this.id = id;
        this.name = name;
        this.origin = origin;
    }

    public static AuthorJpaEntity fromDomain(Author author) {
        return new AuthorJpaEntity(author.getId(), author.getName(), author.getOrigin());
    }

    public Author toDomain() {
        return new Author(id, name, origin);
    }
}
