package com.center;
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

import com.center.config.SecurityUtility;
import com.center.domain.Center;
import com.center.domain.User;
import com.center.domain.security.Role;
import com.center.domain.security.UserRole;
import com.center.service.CenterService;
import com.center.service.UserService;

@SpringBootApplication
public class EyasApplication implements CommandLineRunner{ //

	@Autowired
	private UserService userService;
	
	@Autowired
	private CenterService centerService;
	
	public static void main(String[] args) {
		SpringApplication.run(EyasApplication.class, args);
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
		
		Center center1 =  new Center();
		center1.setType("Preschool");
		center1.setCategory("Academic Based");
		center1.setTeacherToStudentRatio("1 to 4");
		center1.setName("The Grand Master School - Preschool");
		
		center1.setSummary("Beginnings matter. At the Great School Preschool, we understand the importance of giving your "
				+ "child the best possible foundation for an outstanding academic career. That starts with "
				+ "choosing the right school to excite, nurture and challenge children so they are "
				+ "not only ready for the next step but excited to get there.");
		
		center1.setAgeRange("2.5 to 5 years");
		
		center1.setPriceRange("$2400 to $3500");
		
		center1.setSchedule("07:00 AM to 6:00 PM ");
		
		center1.setAddress("4527 Union Ave, San Jose, CA 95144");
		
		center1.setPhone("(408) 553-5721");
		
		center1.setWebsite("http://www.eyaseyes.com");

		
		Center center2 =  new Center();
		
		center2.setTeacherToStudentRatio("1 to 5");
		center2.setName("The Great East Bay Center");
		center1.setType("Play Center");
		center2.setSummary("We operate 25 campuses in California, Idaho, Nevada, Utah, "
				+ "and Texas, with more than 10,000 preschool to 8th grade students enrolled annually."
				+"Our center emphasizes the bedrock of knowledge: reading, composition, math, "
				+ "and history. We promote individual and independent thinking, teach traditional American "
				+ "history and values, and inspire children to embrace challenge and find joy and"
				+ " self-worth through achievement.");
		
		center2.setAgeRange("2 to 5 years");
		
		center2.setPriceRange("$2300 to $3000");
		
		center2.setSchedule("07:00 AM to 6:00 PM ");
		
		center2.setAddress("18831 Cox Avenue Saratoga	CA 95070");
		
		center2.setPhone("(408) 378-1367");
		
		center2.setWebsite("http://www.eyaseyes.com");
		
		//center2.setUserRating(4);
		
		Center center3 = new Center();
		
		center3.setType("Kids Activities Center");
		
		center3.setTeacherToStudentRatio("1 to 4");
		
		center3.setName("South Bay Community Center");
		
		center3.setSummary("South Bay Great Community Center is a non-profit organization supported by tuition "
				+ "only. We do not discriminate in regards to race, color, or creed. SBGCP is licensed for 75 children ages 2 to 5 years old, by the State of California, Department of Health.");
		
		center3.setAgeRange("1.5 to 4 years");
		
		center3.setPriceRange("$1800 to $2800");
		
		center3.setSchedule("07:00 AM to 6:00 PM ");
		
		center3.setAddress("1180 Murphy Ave, San Jose, CA 95131");
		
		center3.setPhone("(408) 890-5111");
		
		center3.setWebsite("http://www.eyaseyes.com");
		
		
		centerService.save(center1);
		centerService.save(center2);
		centerService.save(center3);
    }
}
