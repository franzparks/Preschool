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
	
	List<School> findWishList(String iDs);
	
	School findOne(Long id);
	
	School save(School school);
	
	List<School> blurrySearch(String title);
	
	void removeOne(Long id);

	void updateSchool(School school, int userRating);
}
