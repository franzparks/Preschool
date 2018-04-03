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

import com.center.EyasApplication;
import com.center.config.repository.CenterRepository;

/**
 * @author francisphiri
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = EyasApplication.class)
public class JPAIntegrationTest {
	
	@Autowired
	private CenterRepository schoolRepository;
	
	@Test
    public void givenSchoolRepository_whenSaveAndRetreiveSchool_thenOK() {
		assertTrue(true);
		//School newSchool = schoolRepository.save(new School());
	}
}
