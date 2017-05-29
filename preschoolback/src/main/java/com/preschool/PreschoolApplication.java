package com.preschool;
/**
 * @author francis
 *
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.preschool.service.UserService;

@SpringBootApplication
public class PreschoolApplication implements CommandLineRunner{

	@Autowired
	private UserService userService;
	
	public static void main(String[] args) {
		SpringApplication.run(PreschoolApplication.class, args);
	}

	@Override
    public void run(String... arg0) throws Exception {
	    // TODO Auto-generated method stub
	    
    }
}
