/**
 * 
 */
package com.center.config.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.center.domain.RatingAndReview;
import com.center.domain.Center;
import com.center.domain.User;

/**
 * @author francisphiri
 *
 */
public interface RatingAndReviewRepository extends CrudRepository<RatingAndReview, Long>{
	
	List<RatingAndReview> findByUser(User user);
	List<RatingAndReview> findByCenter(Center center);
	List<RatingAndReview> findByMessageContaining(String message);
	List<RatingAndReview> findAll();
}
