package com.example.demo.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entite.Task;
import com.example.demo.Entite.User;

public interface TaskRepo  extends JpaRepository<Task, Long>{

	List<Task> findByUser(User user);

}
