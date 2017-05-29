/**
 * 
 */
package com.preschool.resource;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.preschool.service.UserService;

/**
 * @author francisphiri
 *
 */
@RestController
@RequestMapping("/review")
public class RatingAndReviewResource {
	
	@Autowired
	private RatingAndReviewService ratingAndReviewService;
	
	@Autowired
	private UserService userService;
	
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
	

	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ResponseEntity addNewReviewPost(
			@RequestBody RatingAndReview ratingAndReview, Principal principal) {
		User user = userService.findByUsername(principal.getName());
		
		ratingAndReview.setUser(user);
		
		ratingAndReviewService.save(ratingAndReview);
		
		return new ResponseEntity("Review Added Successfully!", HttpStatus.OK);
	}
	
	
}
