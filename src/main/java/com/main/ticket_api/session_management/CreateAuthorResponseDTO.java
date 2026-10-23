package com.main.ticket_api.session_management;

public class CreateAuthorResponseDTO {
    private Integer author_id;

    public CreateAuthorResponseDTO(Integer author_id) {
        this.author_id = author_id;
    }

    public Integer getAuthor_id() {
        return author_id;
    }
}
