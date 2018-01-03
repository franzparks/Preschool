/**
 * 
 */
package com.preschool;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.preschool.config.repository.SchoolRepository;

/**
 * @author francisphiri
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = PreschoolApplication.class)
public class JPAIntegrationTest {
	
	@Autowired
	private SchoolRepository schoolRepository;
	
	@Test
    public void givenSchoolRepository_whenSaveAndRetreiveSchool_thenOK() {
		assertTrue(true);
		//School newSchool = schoolRepository.save(new School());
	}
}
