/**
 * 
 */
package com.preschool.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.preschool.config.repository.SchoolRepository;
import com.preschool.domain.School;
import com.preschool.service.SchoolService;

/**
 * @author francisphiri
 *
 */
@Service
public class SchoolServiceImpl implements SchoolService{
	
	@Autowired
	private SchoolRepository schoolRepository;

	@Override
    public List<School> findAll() {    
	    return  schoolRepository.findAll();
    }
	
	@Override
    public List<School> findWishList(String iDs) { 
		System.out.println(iDs);
		String[] listOfIDs = iDs.split(",");
		List<School> schoolList = schoolRepository.findAll();
		List<School> schoolsWishList = new ArrayList<>();
		for(School school : schoolList){
			for(int i = 0; i < listOfIDs.length; i++){
				if(school.getId() == Long.parseLong(listOfIDs[i])){
					schoolsWishList.add(school);
				}
			}
			
		}
		System.out.println(schoolsWishList);
	    return  schoolsWishList;
    }
	

	@Override
    public School findOne(Long id) {
	    return schoolRepository.findOne(id);
    }

	@Override
    public School save(School book) {
	    return schoolRepository.save(book);
    }

	@Override
    public List<School> blurrySearch(String title) {
	    return schoolRepository.findByTitleContaining(title);
    }

	@Override
    public void removeOne(Long id) {
		schoolRepository.delete(id); 
    }
	
}
