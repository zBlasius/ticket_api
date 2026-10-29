package com.main.ticket_api.session_management.domain;

public class Author {
    private final Integer id;
    private final String name;
    private final String origin; // TODO - Shound be another table (too much work for now)

    public Author(Integer id, String name, String origin) {
        this.id = id;
        this.name = name;
        this.origin = origin;
    }

    public static Author create(String name, String origin) {
        return new Author(null, name, origin);
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getOrigin() {
        return origin;
    }
}
