package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.example.demo.course.Course;
import com.example.demo.course.CourseRepository;
import com.example.demo.users.User;
import com.example.demo.users.UserRepository;



@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@Rollback(false)
public class UserRepositoryTest {
	
	@Autowired
	private UserRepository repo;
	

	@Autowired
	private TestEntityManager entityManager;
	
	
	@Test
	public void testCreateUser() {
		
		User user = new User();
		user.setFirstName("kok");
		user.setLastName("love");
		user.setEmail("kok@gmail.com");
		user.setPassword("123456");
		
		User savedUser = repo.save(user);
		User existUser = entityManager.find(User.class, savedUser.getId());
		
		assertThat(existUser.getEmail()).isEqualTo(user.getEmail());
	}
	//new project rest
	@Test
	public void testFindUserByEmail() {
		String email = "mike@gmail.com";
		
		User user = repo.findByEmail(email);
		assertThat(user).isNotNull();
		
	}
	
	
	
	
		
	}
	
	


