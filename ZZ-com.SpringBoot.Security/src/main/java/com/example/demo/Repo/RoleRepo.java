package com.example.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entite.Role;

public interface RoleRepo extends JpaRepository<Role, String> {

}
