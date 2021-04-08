package com.cg.mts.repository;

import com.cg.mts.entities.Users;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface UserRepository extends JpaRepository<Users, Integer> {
   // @Query("SELECT u FROM User u WHERE u.username = ?1")
    public Optional<Users> findByUsername(String username); 
    public Users findByPassword(String password);
}