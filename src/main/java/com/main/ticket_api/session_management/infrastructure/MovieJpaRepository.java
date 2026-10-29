package com.main.ticket_api.session_management.infrastructure;

import com.main.ticket_api.session_management.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

interface MovieJpaRepository extends JpaRepository<MovieJpaEntity, Integer> {

    List<MovieJpaEntity> findByCategoryAndAuthor_Id(Movie.Category category, Integer authorId);
}
