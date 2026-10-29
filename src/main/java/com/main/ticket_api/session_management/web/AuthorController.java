package com.main.ticket_api.session_management.web;

import com.main.ticket_api.session_management.application.CreateAuthorUseCase;
import com.main.ticket_api.session_management.application.GetAuthorUseCase;
import com.main.ticket_api.session_management.application.ListAuthorsUseCase;
import com.main.ticket_api.session_management.domain.Author;
import org.jspecify.annotations.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/author")
public class AuthorController {
    private final CreateAuthorUseCase createAuthorUseCase;
    private final ListAuthorsUseCase listAuthorsUseCase;
    private final GetAuthorUseCase getAuthorUseCase;

    public AuthorController(CreateAuthorUseCase createAuthorUseCase, ListAuthorsUseCase listAuthorsUseCase, GetAuthorUseCase getAuthorUseCase) {
        this.createAuthorUseCase = createAuthorUseCase;
        this.listAuthorsUseCase = listAuthorsUseCase;
        this.getAuthorUseCase = getAuthorUseCase;
    }

    @PostMapping(path = "/add")
    public @ResponseBody CreateAuthorResponseDTO addNewAuthor(@RequestBody @NonNull CreateAuthorRequestDTO request) {
        Author author = createAuthorUseCase.execute(request.getName(), request.getOrigin());
        return new CreateAuthorResponseDTO(author.getId());
    }

    @GetMapping(path = "/all")
    public @ResponseBody List<AuthorResponseDTO> getAllAuthors() {
        return listAuthorsUseCase.execute().stream()
                .map(AuthorResponseDTO::new)
                .toList();
    }

    @GetMapping(path = "get_by_id")
    public @ResponseBody AuthorDetailResponseDTO getAuthorById(@RequestParam Integer author_id) {
        return AuthorDetailResponseDTO.from(getAuthorUseCase.execute(author_id));
    }
}
