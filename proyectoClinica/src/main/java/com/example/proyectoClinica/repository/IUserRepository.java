package com.example.proyectoClinica.repository;

import com.example.proyectoClinica.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<User,Long> {
    Optional<User> getUserByName(@Param("name") String name);
}
