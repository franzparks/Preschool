/**
 * 
 */
package com.preschool.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.preschool.domain.School;
import com.preschool.service.SchoolService;

/**
 * @author francisphiri
 *
 */
@RestController
@RequestMapping("/school")
public class SchoolResource {
	
	@Autowired
	private SchoolService schoolService;
	
	@RequestMapping (value="/addSchool", method=RequestMethod.POST)
	public School addSchoolPost(@RequestBody School school) {
		return schoolService.save(school);
	}
	
}
