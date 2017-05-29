/**
 * 
 */
package com.preschool.service;

import java.util.List;

import com.preschool.domain.RatingAndReview;
import com.preschool.domain.School;

/**
 * @author francisphiri
 *
 */
public interface RatingAndReviewService {
	
	List<RatingAndReview> findAll();
	
	List<RatingAndReview> findBySchool(School school);
	
	RatingAndReview findOne(Long id);
	
	RatingAndReview save(RatingAndReview book);
	
	List<RatingAndReview> blurrySearch(String title);
	
	RatingAndReview updateRatingAndReview(RatingAndReview ratingAndReview);
	
	void removeOne(Long id);
}
