package com.example.bialitski.rock_festival.interfaces;

import com.example.bialitski.rock_festival.model.Groups;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupsRepository extends JpaRepository<Groups, Long> {
}
