package com.rest.blog.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.Id;

import javax.persistence.OneToMany;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Role {
		
	    @Id
	    
		private int id;
		private String name;
		/**One role can have multiple user*/
		@OneToMany(mappedBy="role",cascade= CascadeType.ALL)
		private List<User> user;
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
		public List<User> getUser() {
			return user;
		}
		public void setUser(List<User> user) {
			this.user = user;
		}
		public Role(int id, String name, List<User> user) {
			super();
			this.id = id;
			this.name = name;
			this.user = user;
		}
		public Role() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		
}
