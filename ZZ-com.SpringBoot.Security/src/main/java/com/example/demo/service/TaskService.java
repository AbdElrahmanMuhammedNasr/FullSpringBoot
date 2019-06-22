package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entite.Task;
import com.example.demo.Entite.User;
import com.example.demo.Repo.TaskRepo;

@Service
public class TaskService {

	@Autowired
	private TaskRepo taskRepo;
	
	public void addTask(Task task ,User user) {
		task.setUser(user);
		taskRepo.save(task);
	}
	
	
	public List<Task> findUserTask(User user){
		return taskRepo.findByUser(user);
	}
}
