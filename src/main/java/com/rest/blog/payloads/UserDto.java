package com.rest.blog.payloads;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

	
	private int id;
	@NotNull(message="Name can't be empty.")
	@NotBlank(message="Name is mandatory.")
	@Size(min=4, message="Name must be 4 characters long.")
	private String name;
	@Email(message="Email address is not valid!")
	private String email;
	@NotBlank
	@Size(min=3, max = 10,message="Password must be at least 3 chars and maximum 10 chars.")	
	private String password;
	@NotBlank
	private String about;
	private int newsletter;
	
	private RoleDto role;

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

	public RoleDto getRole() {
		return role;
	}

	public void setRole(RoleDto role) {
		this.role = role;
	}

	
}
