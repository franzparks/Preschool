/**
 * 
 */
package com.preschool.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.preschool.config.repository.RatingAndReviewRepository;
import com.preschool.domain.RatingAndReview;
import com.preschool.domain.School;
import com.preschool.domain.User;
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
	
	
	@Override
	public RatingAndReview updateRatingAndReview(RatingAndReview ratingAndReview) {
		return ratingAndReviewRepository.save(ratingAndReview);
	}
	
	@Override
	public void removeOne(Long id) {
		ratingAndReviewRepository.delete(id);	
	}


	@Override
    public List<RatingAndReview> findBySchool(School school) {    
	    return ratingAndReviewRepository.findBySchool(school);
    }


	@Override
    public List<RatingAndReview> findByUser(User user) {    
	    return ratingAndReviewRepository.findByUser(user);
    }
	
}
