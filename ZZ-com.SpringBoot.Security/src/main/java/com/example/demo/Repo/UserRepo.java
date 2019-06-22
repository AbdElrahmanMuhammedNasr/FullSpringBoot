package com.example.demo.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entite.User;

public interface UserRepo extends JpaRepository<User, String> {

	User findByEmail(String email);

	List<User> findByNameLike(String name);
}
 