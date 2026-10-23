package com.main.ticket_api.session_management;

import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/author")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @PostMapping(path = "/add")
    public @ResponseBody CreateAuthorResponseDTO addNewAuthor(@RequestBody @NonNull CreateAuthorRequestDTO request) {
        Author author = authorService.create(request);
        return new CreateAuthorResponseDTO(author.getId());
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<AuthorResponseDTO> getAllAuthors() {
        // This returns a JSON or XML with the users
        return authorService.findAll().stream()
                .map(AuthorResponseDTO::new)
                .toList();
    }

    @GetMapping(path = "get_by_id")
    public @ResponseBody Author getAuthorById(@RequestParam Integer author_id) {
        return authorService.findOne(author_id);
    }
}
