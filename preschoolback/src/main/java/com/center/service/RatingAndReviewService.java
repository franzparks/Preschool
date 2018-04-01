/**
 * 
 */
package com.center.service;

import java.util.List;

import com.center.domain.RatingAndReview;
import com.center.domain.Center;
import com.center.domain.User;

/**
 * @author francisphiri
 *
 */
public interface RatingAndReviewService {
	
	List<RatingAndReview> findAll();
	
	List<RatingAndReview> findByCenter(Center center);
	
	List<RatingAndReview> findByUser(User user);
	
	RatingAndReview findOne(Long id);
	
	RatingAndReview save(RatingAndReview ratingAndReview);
	
	List<RatingAndReview> blurrySearch(String title);
	
	RatingAndReview updateRatingAndReview(RatingAndReview ratingAndReview);
	
	void removeOne(Long id);
}
