/**
 * 
 */
package com.center.service;

import java.util.List;

import com.center.domain.RatingAndReview;
import com.center.domain.Center;

/**
 * @author francisphiri
 *
 */
public interface CenterService {
	
	List<Center> findAll();
	
	List<Center> findWishList(String iDs);
	
	Center findOne(Long id);
	
	Center save(Center center);
	
	List<Center> blurrySearch(String title);
	
	void removeOne(Long id);

	void updateAverageCenterRating(Center center,RatingAndReview ratingAndReview);
}
