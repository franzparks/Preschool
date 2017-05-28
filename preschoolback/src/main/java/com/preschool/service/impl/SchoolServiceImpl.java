/**
 * 
 */
package com.preschool.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.preschool.config.repository.SchoolRepository;
import com.preschool.domain.School;
import com.preschool.service.SchoolService;

/**
 * @author francisphiri
 *
 */
public class SchoolServiceImpl implements SchoolService{
	
	@Autowired
	private SchoolRepository schoolRepository;

	@Override
    public List<School> findAll() {
	    
	    return (List<School>) schoolRepository.findAll();
    }

	@Override
    public School findOne(Long id) {
	    // TODO Auto-generated method stub
	    return null;
    }

	@Override
    public School save(School book) {
	    // TODO Auto-generated method stub
	    return null;
    }

	@Override
    public List<School> blurrySearch(String title) {
	    // TODO Auto-generated method stub
	    return null;
    }

	@Override
    public void removeOne(Long id) {
	    // TODO Auto-generated method stub
	    
    }
	
}
