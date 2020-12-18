package com.ja.jademo.repository;

import com.ja.jademo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    void deleteById(Long id);
    //User findByUsername(String username);
}
