/**
 * 
 */
package com.preschool.resource;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.preschool.domain.RatingAndReview;
import com.preschool.domain.School;
import com.preschool.domain.User;
import com.preschool.service.RatingAndReviewService;

/**
 * @author francisphiri
 *
 */
@RestController
@RequestMapping("/review")
public class RatingAndReviewResource {
	
	private RatingAndReviewService ratingAndReviewService;
	
	@RequestMapping (value="/all", method=RequestMethod.POST)
	public List<RatingAndReview> findAllBySchool(@RequestBody School school){
		return ratingAndReviewService.findBySchool(school);
	}
	
	@RequestMapping (value="/byUser", method=RequestMethod.POST)
	public List<RatingAndReview> findAllByUser(@RequestBody User user){
		return ratingAndReviewService.findByUser(user);
	}
	
	@RequestMapping (value="/{id}", method=RequestMethod.GET)
	RatingAndReview findById(@PathVariable("id") Long id){
		RatingAndReview ratingAndReview = ratingAndReviewService.findOne(id);
		return ratingAndReview;	
	}
	
	@RequestMapping (value="/save", method=RequestMethod.POST)
	RatingAndReview save(@RequestBody RatingAndReview ratingAndReview){
		RatingAndReview ratingAndReviewOutPut = ratingAndReviewService.save(ratingAndReview);
		return 	ratingAndReviewOutPut;
	}
	
	
}
