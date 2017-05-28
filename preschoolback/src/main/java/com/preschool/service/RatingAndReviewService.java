/**
 * 
 */
package com.preschool.service;

import java.util.List;

import com.preschool.domain.RatingAndReview;

/**
 * @author francisphiri
 *
 */
public interface RatingAndReviewService {
	
	List<RatingAndReview> findAll();
	
	RatingAndReview findOne(Long id);
	
	RatingAndReview save(RatingAndReview book);
	
	List<RatingAndReview> blurrySearch(String title);
	
	RatingAndReview updateRatingAndReview(RatingAndReview ratingAndReview);
	
	void removeOne(Long id);
}
