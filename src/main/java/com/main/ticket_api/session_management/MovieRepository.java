package com.main.ticket_api.session_management;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Integer> {

    List<Movie> findByName(String name); // Check if it works

    List<Movie> findByCategoryAndAuthor_id(Movie.Category category, Integer author_id);

    @Override
    List<Movie> findAll();
}
