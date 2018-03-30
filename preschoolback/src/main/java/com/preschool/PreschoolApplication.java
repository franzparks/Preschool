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
public class PreschoolApplication implements CommandLineRunner{ //

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
		school1.setTeacherToStudentRatio("1 to 4");
		school1.setTitle("The Great School - Preschool");
		
		school1.setSummary("Beginnings matter. At Great, we understand the importance of giving your "
				+ "child the best possible foundation for an outstanding academic career. That starts with "
				+ "choosing the right preschool to excite, nurture and challenge children so they are "
				+ "not only ready for the next step but excited to get there.");
		
		school1.setAgeRange("2.5 to 5 years");
		
		school1.setPriceRange("$2400 to $3500");
		
		school1.setSchedule("07:00 AM to 6:00 PM ");
		
		school1.setAddress("4527 Union Ave, San Jose, CA 95144");
		
		school1.setPhone("(408) 553-5721");
		
		school1.setWebsite("http://www.eyaseyes.com");
		
		//school1.setAverageRating(4);
		
		School school2 =  new School();
		school2.setTeacherToStudentRatio("1 to 5");
		school2.setTitle("The Other Great School");
		
		school2.setSummary("We operate 25 campuses in California, Idaho, Nevada, Utah, "
				+ "and Texas, with more than 10,000 preschool to 8th grade students enrolled annually."
				+"Our school emphasizes the bedrock of knowledge: reading, composition, math, "
				+ "and history. We promote individual and independent thinking, teach traditional American "
				+ "history and values, and inspire children to embrace challenge and find joy and"
				+ " self-worth through achievement.");
		
		school2.setAgeRange("2 to 5 years");
		
		school2.setPriceRange("$2300 to $3000");
		
		school2.setSchedule("07:00 AM to 6:00 PM ");
		
		school2.setAddress("18831 Cox Avenue Saratoga	CA 95070");
		
		school2.setPhone("(408) 378-1367");
		
		school2.setWebsite("http://www.eyaseyes.com");
		
		//school2.setAverageRating(4);
		
		School school3 = new School();
		
		school3.setTeacherToStudentRatio("1 to 4");
		
		school3.setTitle("South Bay Great Community Preschool");
		
		school3.setSummary("South Bay Great Community Preschool is a non-profit organization supported by tuition "
				+ "only. We do not discriminate in regards to race, color, or creed. SBGCP is licensed for 75 children ages 2 to 5 years old, by the State of California, Department of Health.");
		
		school3.setAgeRange("1.5 to 4 years");
		
		school3.setPriceRange("$1800 to $2800");
		
		school3.setSchedule("07:00 AM to 6:00 PM ");
		
		school3.setAddress("1180 Murphy Ave, San Jose, CA 95131");
		
		school3.setPhone("(408) 890-5111");
		
		school3.setWebsite("http://www.eyaseyes.com");
		
		//school3.setAverageRating(3);

		
		schoolService.save(school1);
		schoolService.save(school2);
		schoolService.save(school3);
    }
}
