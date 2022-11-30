package com.example.bialitski.rock_festival.interfaces;

import com.example.bialitski.rock_festival.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {
    User findByUsername(String username);
}
