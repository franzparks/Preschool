/**
 * 
 */
package com.preschool.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	@OneToMany(mappedBy = "school", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JsonIgnore
	private List<RatingAndReview> ratingAndReviewsList;
	
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
