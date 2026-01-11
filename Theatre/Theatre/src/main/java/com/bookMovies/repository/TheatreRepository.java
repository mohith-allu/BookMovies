package com.bookMovies.repository;

import com.bookMovies.dto.TheatreDetails;
import com.bookMovies.model.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre,Long> {

    boolean existsByName(String name);

    @Query("select t.id from Theatre t where t.name=:name")
    Long findIdByName(@Param("name") String name);

    @Query("select new com.bookMovies.dto.TheatreDetails(t.name,t.address) from Theatre t" +
            " where t.id=:id")
    TheatreDetails getNameAndAddressById(@Param("id") Long id);
}
