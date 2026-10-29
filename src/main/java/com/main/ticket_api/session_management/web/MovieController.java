package com.main.ticket_api.session_management.web;

import com.main.ticket_api.session_management.application.CreateMovieUseCase;
import com.main.ticket_api.session_management.application.FindMoviesUseCase;
import com.main.ticket_api.session_management.application.ListMoviesUseCase;
import com.main.ticket_api.session_management.domain.Movie;
import org.jspecify.annotations.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/movie")
public class MovieController {
    private final CreateMovieUseCase createMovieUseCase;
    private final FindMoviesUseCase findMoviesUseCase;
    private final ListMoviesUseCase listMoviesUseCase;

    public MovieController(CreateMovieUseCase createMovieUseCase, FindMoviesUseCase findMoviesUseCase, ListMoviesUseCase listMoviesUseCase) {
        this.createMovieUseCase = createMovieUseCase;
        this.findMoviesUseCase = findMoviesUseCase;
        this.listMoviesUseCase = listMoviesUseCase;
    }

    @PostMapping(path = "/add")
    public @ResponseBody CreateMovieResponseDTO addNewMovie(@RequestBody @NonNull CreateMovieRequestDTO request) {
        Movie movie = createMovieUseCase.execute(new CreateMovieUseCase.Command( // ??
                request.getName(),
                request.getAuthor_id(),
                request.getCategory(),
                request.getRelease_date() == null ? null : request.getRelease_date().toLocalDateTime(),
                request.getDuration()));
        return new CreateMovieResponseDTO(movie.getId());
    }

    @GetMapping(path = "/find")
    public @ResponseBody List<MovieResponseDTO> find(@RequestParam Movie.@NonNull Category category, @RequestParam Integer author) {
        return findMoviesUseCase.execute(category, author).stream()
                .map(MovieResponseDTO::from)
                .toList();
    }

    @GetMapping(path = "/find_all")
    public @ResponseBody List<MovieResponseDTO> findAll() {
        return listMoviesUseCase.execute().stream()
                .map(MovieResponseDTO::from)
                .toList();
    }
}
