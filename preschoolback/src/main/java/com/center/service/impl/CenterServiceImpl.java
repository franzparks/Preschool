/**
 * 
 */
package com.center.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.center.config.repository.CenterRepository;
import com.center.domain.RatingAndReview;
import com.center.domain.Center;
import com.center.service.CenterService;

/**
 * @author francisphiri
 *
 */
@Service
public class CenterServiceImpl implements CenterService{
	
	@Autowired
	private CenterRepository centerRepository;

	@Override
    public List<Center> findAll() {    
	    return  centerRepository.findAll();
    }
	
	@Override
    public List<Center> findWishList(String iDs) { 
		List<Center> centersWishList = new ArrayList<>();
		
		if(iDs == null) return centersWishList;
		
		if(iDs.length() == 1){
			Center center = centerRepository.findOne(Long.valueOf(iDs));
			centersWishList.add(center);
			return centersWishList;
		}
		String[] listOfIDs = iDs.split(",");
		
		List<Center> centerList = centerRepository.findAll();
		for(Center center : centerList){
			for(int i = 0; i < listOfIDs.length; i++){
				if(center.getId() == Long.parseLong(listOfIDs[i])){
					centersWishList.add(center);
				}
			}
			
		}
		System.out.println(centersWishList);
	    return  centersWishList;
    }
	

	@Override
    public Center findOne(Long id) {
	    return centerRepository.findOne(id);
    }

	@Override
    public Center save(Center center) {
	    return centerRepository.save(center);
    }

	@Override
    public List<Center> blurrySearch(String name) {
	    return centerRepository.findByNameContaining(name);
    }

	@Override
    public void removeOne(Long id) {
		centerRepository.delete(id); 
    }

	@Override
    public void updateAverageCenterRating(Center center, RatingAndReview ratingAndReview) {
		
		int averageRating = 0;	
		int totalRatings = 0;
		int sumOfRatings = 0;
		
		List<RatingAndReview> ratingAndReviewsList = center.getRatingAndReviewsList();
		ratingAndReviewsList.add(ratingAndReview);
		center.setRatingAndReviewsList(ratingAndReviewsList);
		
		totalRatings =  center.getRatingAndReviewsList().size();
		
		for(RatingAndReview review : center.getRatingAndReviewsList()) {
			sumOfRatings += review.getUserRating();
		}
		
		averageRating = totalRatings == 0 ? sumOfRatings : (int) Math.floor(sumOfRatings / totalRatings);
		center.setAverageRating(averageRating);
		centerRepository.save(center);
    }
	
}
