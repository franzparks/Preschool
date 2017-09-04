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
public class PreschoolApplication { //implements CommandLineRunner

	//@Autowired
	//private UserService userService;
	
	//@Autowired
	//private SchoolService schoolService;
	
	public static void main(String[] args) {
		SpringApplication.run(PreschoolApplication.class, args);
	}

	//@Override
    //public void run(String... arg0) throws Exception {
		/*User user1 = new User();
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
		
		//userService.createUser(user1, userRoles);
		
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
		
		//userService.createUser(user2, userRoles);
		
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
		
		School school2 =  new School();
		school2.setTitle("Challenger School");
		school2.setSubTitle("The premier school in the country");
		school2.setSnippet("Challenger School is an independent, "
				+ "non-profit private school. To preserve our independence,"
				+ " we do not accept public funds. However, as a non-profit entity, "
				+ "we accept private, tax-deductible donations from those wishing to"
				+ " contribute to our educational mission.");
		
		school2.setSummary("We operate 25 campuses in California, Idaho, Nevada, Utah, "
				+ "and Texas, with more than 10,000 preschool to 8th grade students enrolled annually."
				+"Challenger emphasizes the bedrock of knowledge: reading, composition, math, "
				+ "and history. We promote individual and independent thinking, teach traditional American "
				+ "history and values, and inspire children to embrace challenge and find joy and"
				+ " self-worth through achievement.");
		
		school2.setAddress("18811 Cox Avenue Saratoga	CA 95070");
		
		school2.setPhone("(408) 378-0444");
		
		school2.setAverageRating(4);
		
		School school3 = new School();
		
		school3.setTitle("South Bay Community Preschool");
		school3.setSubTitle("Discovering that learning is fun!");
		school3.setSnippet("South Bay Community Preschool is a non-profit "
				+ "organization supported by tuition only.");
		school3.setSummary("South Bay Community Preschool is a non-profit organization supported by tuition "
				+ "only. We do not discriminate in regards to race, color, or creed. SBCP is licensed for 75 children ages 2 to 5 years old, by the State of California, Department of Health.");
		school3.setAddress("1180 Murphy Ave, San Jose, CA 95131");
		school3.setPhone("(408) 890-5010");
		school3.setAverageRating(3);

		
		//schoolService.save(school1);
		//schoolService.save(school2);
		//schoolService.save(school3);*/
    //}
}
