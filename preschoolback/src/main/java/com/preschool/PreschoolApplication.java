package com.preschool;
/**
 * @author francis
 *
 */
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.preschool.config.SecurityUtility;
import com.preschool.domain.School;
import com.preschool.domain.User;
import com.preschool.domain.security.Role;
import com.preschool.domain.security.UserRole;
import com.preschool.service.SchoolService;
import com.preschool.service.UserService;

@SpringBootApplication
public class PreschoolApplication implements CommandLineRunner{

	@Autowired
	private UserService userService;
	
	@Autowired
	private SchoolService schoolService;
	
	public static void main(String[] args) {
		SpringApplication.run(PreschoolApplication.class, args);
	}

	@Override
    public void run(String... arg0) throws Exception {
		User user1 = new User();
		user1.setFirstName("John");
		user1.setLastName("Adams");
		user1.setUsername("j");
		user1.setPassword(SecurityUtility.passwordEncoder().encode("p"));
		user1.setEmail("nursery.express@gmail.com");
		Set<UserRole> userRoles = new HashSet<>();
		Role role1 = new Role();
		role1.setRoleId(1);
		role1.setName("ROLE_USER");
		userRoles.add(new UserRole(user1, role1));
		
		userService.createUser(user1, userRoles);
		
		userRoles.clear();
		
		User user2 = new User();
		user2.setFirstName("Admin");
		user2.setLastName("Admin");
		user2.setUsername("admin");
		user2.setPassword(SecurityUtility.passwordEncoder().encode("p"));
		user2.setEmail("Admin@gmail.com");
		Role role2 = new Role();
		role2.setRoleId(0);
		role2.setName("ROLE_ADMIN");
		userRoles.add(new UserRole(user2, role2));
		
		userService.createUser(user2, userRoles);
		
		School school1 =  new School();
		school1.setTitle("The Harker School - Preschool");
		school1.setSubTitle("The bay\'s best");
		school1.setSnippet("At Harker’s preschool, our early learning program for 3-, 4- and young"
				+ " 5-year-olds emphasizes hands-on learning,"
				+ " intentional play and developmentally appropriate classroom activities.");
		
		school1.setSummary("Beginnings matter. At Harker, we understand the importance of giving your "
				+ "child the best possible foundation for an outstanding academic career. That starts with "
				+ "choosing the right preschool to excite, nurture and challenge children so they are "
				+ "not only ready for the next step but excited to get there.");
		
		school1.setAddress("4525 Union Ave, San Jose, CA 95124");
		
		school1.setPhone("(408) 553-5700");
		
		school1.setAverageRating(4);
		
		schoolService.save(school1);
    }
}
