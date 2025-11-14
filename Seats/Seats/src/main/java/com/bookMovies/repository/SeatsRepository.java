package com.bookMovies.repository;

import com.bookMovies.dto.SeatsRequest;
import com.bookMovies.model.Seats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatsRepository extends JpaRepository<Seats,Long> {

    boolean existsByTheatreIdAndScreenNumber(Long theatreId,int screenNumber);

    @Query("select s.id from Seats s where s.theatreId=:theatreId and s.screenNumber=:screenNumber")
    List<Long> getIdByTheatreIdAndScreenNumber(@Param("theatreId") Long theatreId,
                                               @Param("screenNumber") int screenNumber);

    @Query("select new com.bookMovies.dto.SeatsRequest(s.seatType,s.totalSeats,s.price)" +
            " from Seats s where s.theatreId=:theatreId and s.screenNumber=:screenNumber")
    List<SeatsRequest> getSeatsByTheatreIdAndScreenNumber(@Param("theatreId") Long theatreId,
                                                          @Param("screenNumber") int screenNumber);
}
