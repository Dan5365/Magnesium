package com.example.serving_web_content.repository;

import com.example.serving_web_content.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {

}
