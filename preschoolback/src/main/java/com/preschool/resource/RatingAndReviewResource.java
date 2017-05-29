/**
 * 
 */
package com.preschool.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.preschool.service.RatingAndReviewService;

/**
 * @author francisphiri
 *
 */
@RestController
@RequestMapping("/review")
public class RatingAndReviewResource {
	
	private RatingAndReviewService ratingAndReviewService;
	
}
