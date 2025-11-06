package com.bookMovies.repository;

import com.bookMovies.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users,Long> {

    boolean existsByEmailAndPassword(String email,String password);
    boolean existsByEmail(String email);
    @Query("select u.id from Users u where u.email=:email")
    Long findIdByEmail(@Param("email") String email);
}
