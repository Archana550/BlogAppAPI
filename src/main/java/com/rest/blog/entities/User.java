

package com.rest.blog.entities;

//import java.beans.JavaBean;
import java.io.Serializable;
import java.util.ArrayList;

import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;

import lombok.Setter;

@Entity
@Table(name="users")

@Getter
@Setter
@AllArgsConstructor
//@JavaBean
public class User implements Serializable  {

	private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private int id;
  @Column(name="user_name", nullable=false, length=100)
  @NotBlank(message="Name cannot be null")
  private String name;
  @Email(message="Please enter correct mail.")
  private String email;
  @NotBlank
  private String password;
  @NotBlank
  private String about;
  
  private int newsletter;
  

	@OneToMany(mappedBy ="user", cascade=CascadeType.ALL) 
	private List<Post> posts = new ArrayList<>();
	
	/**Many users can have same role*/
	/**If a user is deleted, then all his/her posts will get deleted.*/
	@ManyToOne
	@JoinTable(name="user_role")
	private Role role; 

	
	public User() {

    }

	/**Constructor to signup*/
	public User(String name, String email, String password, String about) {
		
		this.name= name;
		this.email=email;
		this.password=password;
		this.about= about;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public int getNewsletter() {
		return newsletter;
	}

	public void setNewsletter(int newsletter) {
		this.newsletter = newsletter;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
  
}
