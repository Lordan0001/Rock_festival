package com.example.bialitski.rock_festival.interfaces;

import com.example.bialitski.rock_festival.model.Albums;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumsRepository extends JpaRepository<Albums,Long> {
}
