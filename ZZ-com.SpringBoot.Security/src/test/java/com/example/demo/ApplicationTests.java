package com.example.demo;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.Entite.Task;
import com.example.demo.Entite.User;
import com.example.demo.service.TaskService;
import com.example.demo.service.Userservice;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	

	@Autowired
	private Userservice userservice;
	
	@Autowired
	private TaskService taskService;
	
	@Before
	public void initDb() {
		
		{
			User newUser = new User("UserEmail@gmail.com", "UserName", "123456");
			userservice.createAdmin(newUser);
		}
		
		{
			User newUser = new User("UserEmailTwo@gmail.com", "UserNameTwo", "123456");
			userservice.createAdmin(newUser);
		}
		
		
		
		Task userTask = new Task("1-1-2018", "00:11", "11:00", "Work Decs");
		User user = userservice.findOne("UserEmail@gmail.com");
		taskService .addTask(userTask, user);
	}
	
	
	@Test
	public void testUser() {
		
		User user = userservice.findOne("UserEmail@gmail.com");
		assertNotNull(user);
		
		User admin = userservice.findOne("UserEmailTwo@gmail.com");
		assertEquals(admin.getEmail(), "UserEmailTwo@gmail.com");
	}
	
	
	@Test
	public void testTask() {
		
		User user = userservice.findOne("UserEmail@gmail.com");
		List<Task> task =taskService.findUserTask(user);
		assertNotNull(task);
		
	}
}


















