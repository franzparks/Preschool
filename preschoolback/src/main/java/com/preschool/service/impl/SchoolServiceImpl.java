/**
 * 
 */
package com.preschool.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.preschool.config.repository.SchoolRepository;
import com.preschool.domain.RatingAndReview;
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
		List<School> schoolsWishList = new ArrayList<>();
		
		if(iDs == null) return schoolsWishList;
		
		if(iDs.length() == 1){
			School school = schoolRepository.findOne(Long.valueOf(iDs));
			schoolsWishList.add(school);
			return schoolsWishList;
		}
		String[] listOfIDs = iDs.split(",");
		
		List<School> schoolList = schoolRepository.findAll();
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
    public School save(School school) {
	    return schoolRepository.save(school);
    }

	@Override
    public List<School> blurrySearch(String title) {
	    return schoolRepository.findByTitleContaining(title);
    }

	@Override
    public void removeOne(Long id) {
		schoolRepository.delete(id); 
    }

	@Override
    public void updateAverageSchoolRating(School school, RatingAndReview ratingAndReview) {
		
		int averageRating = 0;	
		int totalRatings = 0;
		int sumOfRatings = 0;
		
		List<RatingAndReview> ratingAndReviewsList = school.getRatingAndReviewsList();
		ratingAndReviewsList.add(ratingAndReview);
		school.setRatingAndReviewsList(ratingAndReviewsList);
		
		totalRatings =  school.getRatingAndReviewsList().size();
		
		for(RatingAndReview review : school.getRatingAndReviewsList()) {
			sumOfRatings += review.getUserRating();
		}
		
		averageRating = totalRatings == 0 ? sumOfRatings : (int) Math.floor(sumOfRatings / totalRatings);
		school.setAverageRating(averageRating);
		schoolRepository.save(school);
    }
	
}
