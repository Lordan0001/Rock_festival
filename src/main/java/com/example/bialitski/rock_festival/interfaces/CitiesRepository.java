package com.example.bialitski.rock_festival.interfaces;


import com.example.bialitski.rock_festival.model.Cities;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CitiesRepository extends JpaRepository<Cities,Long> {
}
