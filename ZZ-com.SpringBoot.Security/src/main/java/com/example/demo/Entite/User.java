package com.example.demo.Entite;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class User {
	
	@Id
	@Email
	@NotEmpty
	@Column(unique=true)
	private String email;
	
	@NotEmpty
	private String name;
	
	@Size(min=4)
	private String password;
	
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL)
	private List<Task> task;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="USER_ROLES" ,joinColumns={
		@JoinColumn(name="USER_EMAIL" , referencedColumnName="email")  } , inverseJoinColumns = {
		@JoinColumn(name="ROLE_NAME" ,referencedColumnName="name")		
		})
	private List<Role> role;
	
	public User() {
		
	}
	
	public User(String email, String name, String password) {
		super();
		this.email = email;
		this.name = name;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Task> getTask() {
		return task;
	}

	public void setTask(List<Task> task) {
		this.task = task;
	}

	public List<Role> getRole() {
		return role;
	}

	public void setRole(List<Role> role) {
		this.role = role;
	}
	
		


}
