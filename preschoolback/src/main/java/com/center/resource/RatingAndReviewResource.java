/**
 * 
 */
package com.center.resource;

import java.security.Principal;
import java.util.Date;
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

import com.center.domain.RatingAndReview;
import com.center.domain.Center;
import com.center.domain.User;
import com.center.service.RatingAndReviewService;
import com.center.service.CenterService;
import com.center.service.UserService;

/**
 * @author francisphiri
 *
 */

@RestController
@RequestMapping("/reviews")
public class RatingAndReviewResource {
	
	@Autowired
	private RatingAndReviewService ratingAndReviewService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CenterService centerService;
	
	@RequestMapping (value="{id}/all")
	public List<RatingAndReview> findAllByCenter(@PathVariable("id") Long id){
		Center center = centerService.findOne(id);
		return ratingAndReviewService.findByCenter(center);
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
		
		Center center = centerService.findOne(new Long(ratingAndReview.getGivenCenterId()));
		ratingAndReview.setCenter(center);
		ratingAndReview.setDate(new Date());
		ratingAndReviewService.save(ratingAndReview);
		System.out.println("sent review :: "+ratingAndReview);
		
		centerService.updateAverageCenterRating(center, ratingAndReview);
		
		return new ResponseEntity("Review Added Successfully!", HttpStatus.OK);
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public RatingAndReview updateReviewPost(@RequestBody RatingAndReview ratingAndReview) {
		return ratingAndReviewService.save(ratingAndReview);
	}
	
	@RequestMapping(value="/remove", method=RequestMethod.POST)
	public ResponseEntity removeReviewPost(
			@RequestBody String id,
			Principal principal
			) {
		ratingAndReviewService.removeOne(Long.parseLong(id));
		return new ResponseEntity("Review Removed Successfully!", HttpStatus.OK);
	}
	
	
}

