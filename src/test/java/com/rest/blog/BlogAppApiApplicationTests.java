package com.rest.blog;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertThrows;


import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.rest.blog.entities.Post;
import com.rest.blog.entities.User;
import com.rest.blog.repositories.PostRepo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RunWith(SpringRunner.class)
@SpringBootTest
class BlogAppApiApplicationTests {

	public static final Logger Logger = LoggerFactory.getLogger(BlogAppApiApplicationTests.class);

	@Autowired
	private PostRepo postrepo;
	
	@Test
	public void testAddUser() {
		RestTemplate template = new RestTemplate();
		User userobj = new User("Raman", "raman1@gmail.com", "password", "I am an artist");
		User user = template.postForObject("http://localhost:8080/api/auth/register", userobj, User.class);
		System.out.println(userobj);
		assertNotNull(userobj);
		assertEquals(userobj.getEmail(), user.getEmail());

	}


}
