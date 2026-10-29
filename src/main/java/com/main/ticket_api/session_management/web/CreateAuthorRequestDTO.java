package com.main.ticket_api.session_management.web;

public class CreateAuthorRequestDTO {

    private String name;

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String origin;

}

