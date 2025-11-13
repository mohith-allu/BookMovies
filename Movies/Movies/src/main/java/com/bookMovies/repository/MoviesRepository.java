package com.bookMovies.repository;

import com.bookMovies.model.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MoviesRepository extends JpaRepository<Movies,Long> {

    boolean existsByTitle(String title);
    @Query("select m.id from Movies m where m.title=:title")
    Long getIdByTitle(@Param("title") String title);
}
