package com.main.ticket_api.user;

import java.time.LocalDate;

public class CreateUserRequestDTO {
    private String name;
    private String email;
    private String password;
    private LocalDate birthDate;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }
}
