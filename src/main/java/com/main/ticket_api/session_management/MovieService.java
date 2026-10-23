package com.main.ticket_api.session_management;

import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

interface IMovieService {
    public Movie create(@NonNull CreateMovieRequestDTO request);
    public List<Movie> getByFilter(Movie.Category category, Integer author_id);
    public List<Movie> findAll();
}

@Service
public class MovieService implements IMovieService {

    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private AuthorService authorService;

    public Movie create(@NonNull CreateMovieRequestDTO request) {
        Author author = authorService.findOne(request.getAuthor_id());

        if (author == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "author_id not found");
        }

        Movie movie = new Movie();
        movie.setCategory(request.getCategory());
        movie.setName(request.getName());
        movie.setAuthor(author);
        movie.setDuration(request.getDuration());
        movieRepository.save(movie);
        return movie;
    }

    public List<Movie> getByFilter(Movie.Category category, Integer author_id) {
        return movieRepository.findByCategoryAndAuthor_id(category, author_id);
    }

    public List<Movie> findAll(){
        return movieRepository.findAll();
    }

}
