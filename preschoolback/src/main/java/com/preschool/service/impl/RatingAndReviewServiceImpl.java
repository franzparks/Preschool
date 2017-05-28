/**
 * 
 */
package com.preschool.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.preschool.config.repository.RatingAndReviewRepository;
import com.preschool.domain.RatingAndReview;
import com.preschool.service.RatingAndReviewService;

/**
 * @author francisphiri
 *
 */
public class RatingAndReviewServiceImpl implements RatingAndReviewService {
	
	@Autowired
	private RatingAndReviewRepository ratingAndReviewRepository;
	
	@Override
	public List<RatingAndReview> findAll() {
		return ratingAndReviewRepository.findAll();
	}
	

	@Override
	public RatingAndReview findOne(Long id) {
		return ratingAndReviewRepository.findOne(id);
	}
	
	@Override
	public RatingAndReview save(RatingAndReview review) {
		return ratingAndReviewRepository.save(review);
	}
	
	
	@Override
	public List<RatingAndReview> blurrySearch(String message) {
		return ratingAndReviewRepository.findByMessageContaining(message);
	}
	
	/* (non-Javadoc)
	 * @see com.preschool.service.RatingAndReviewService#updateRatingAndReview(com.preschool.domain.RatingAndReview)
	 */
	@Override
	public RatingAndReview updateRatingAndReview(RatingAndReview ratingAndReview) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/* (non-Javadoc)
	 * @see com.preschool.service.RatingAndReviewService#removeOne(java.lang.Long)
	 */
	@Override
	public void removeOne(Long id) {
		// TODO Auto-generated method stub
		
	}
	
}
