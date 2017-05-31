/**
 * 
 */
package com.preschool.service;

import java.util.List;

import com.preschool.domain.School;

/**
 * @author francisphiri
 *
 */
public interface SchoolService {
	List<School> findAll();
	
	School findOne(Long id);
	
	School save(School school);
	
	List<School> blurrySearch(String title);
	
	void removeOne(Long id);
}
