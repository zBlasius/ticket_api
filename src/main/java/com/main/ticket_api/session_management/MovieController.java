package com.main.ticket_api.session_management;

import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping(path = "/add")
    public @ResponseBody CreateMovieResponseDTO addNewMovie(@RequestBody @NonNull CreateMovieRequestDTO request) {
        Movie movie = movieService.create(request);
        return new CreateMovieResponseDTO(movie.getId());
    }

    @GetMapping(path ="/find")
    public @ResponseBody List<Movie> find(@RequestParam Movie.@NonNull Category category, @RequestParam String author) {
        Integer author_id = author == null ? null : Integer.parseInt(author);
        Movie.Category _movie_category = Movie.Category.valueOf(category.toString());
        return movieService.getByFilter(_movie_category, author_id);
    }

    @GetMapping(path ="/find_all")
    public @ResponseBody List<Movie> findAll() {
        return movieService.findAll();
    }
}
