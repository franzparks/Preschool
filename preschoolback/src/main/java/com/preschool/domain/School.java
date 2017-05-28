/**
 * 
 */
package com.preschool.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author francis
 *
 */

@Entity
public class School implements Serializable{
	
	private static final long serialVersionUID=425345L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private RatingAndReview ratingAndReview;
	
	private String title;
	private String subTitle;
	private String snippet;
	
	@Column(columnDefinition="text")
	private String summary;
	
	private String address;
	private String phone;
	private int averageRating;
	
	@Transient
	private MultipartFile schoolImage;

	
	

}
