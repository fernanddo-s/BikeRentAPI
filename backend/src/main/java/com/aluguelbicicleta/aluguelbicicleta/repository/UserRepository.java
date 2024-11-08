package com.aluguelbicicleta.aluguelbicicleta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.aluguelbicicleta.aluguelbicicleta.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
    
    UserDetails findByLogin(String login);
}
