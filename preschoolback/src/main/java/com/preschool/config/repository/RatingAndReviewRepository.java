/**
 * 
 */
package com.preschool.config.repository;

import org.springframework.data.repository.CrudRepository;

import com.preschool.domain.RatingAndReview;
import com.preschool.domain.User;

/**
 * @author francisphiri
 *
 */
public interface RatingAndReviewRepository extends CrudRepository<RatingAndReview, Long>{
	
}
