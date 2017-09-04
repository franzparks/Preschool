/**
 * 
 */
package com.preschool.service;

import java.util.List;

import com.preschool.domain.RatingAndReview;
import com.preschool.domain.School;
import com.preschool.domain.User;

/**
 * @author francisphiri
 *
 */
public interface RatingAndReviewService {
	
	List<RatingAndReview> findAll();
	
	List<RatingAndReview> findBySchool(School school);
	
	List<RatingAndReview> findByUser(User user);
	
	RatingAndReview findOne(Long id);
	
	RatingAndReview save(RatingAndReview ratingAndReview);
	
	List<RatingAndReview> blurrySearch(String title);
	
	RatingAndReview updateRatingAndReview(RatingAndReview ratingAndReview);
	
	void removeOne(Long id);
}
