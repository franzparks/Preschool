/**
 * 
 */
package com.center.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.center.domain.RatingAndReview;
import com.center.domain.Center;
import com.center.config.repository.RatingAndReviewRepository;
import com.center.domain.User;
import com.center.service.RatingAndReviewService;

/**
 * @author francisphiri
 *
 */
@Service
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
	
	
	@Override
	public RatingAndReview updateRatingAndReview(RatingAndReview ratingAndReview) {
		return ratingAndReviewRepository.save(ratingAndReview);
	}
	
	@Override
	public void removeOne(Long id) {
		ratingAndReviewRepository.delete(id);	
	}


	@Override
    public List<RatingAndReview> findByCenter(Center school) {    
	    return ratingAndReviewRepository.findByCenter(school);
    }


	@Override
    public List<RatingAndReview> findByUser(User user) {    
	    return ratingAndReviewRepository.findByUser(user);
    }
	
}
