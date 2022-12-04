package com.example.bialitski.rock_festival.interfaces;


import com.example.bialitski.rock_festival.model.Cities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CitiesRepository extends JpaRepository<Cities,Long> {

    @Query(value = "SELECT * FROM cities WHERE userOfTicket = :username",nativeQuery = true)
    public List<Cities> getTicketsByUsername(String username);
}
