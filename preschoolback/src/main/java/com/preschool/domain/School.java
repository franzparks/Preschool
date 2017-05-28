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

	public Long getId() {
		return id;
	}

	public List<RatingAndReview> getRatingAndReviewsList() {
		return ratingAndReviewsList;
	}

	public String getTitle() {
		return title;
	}

	public String getSubTitle() {
		return subTitle;
	}

	public String getSnippet() {
		return snippet;
	}

	public String getSummary() {
		return summary;
	}

	public String getAddress() {
		return address;
	}

	public String getPhone() {
		return phone;
	}

	public int getAverageRating() {
		return averageRating;
	}

	public MultipartFile getSchoolImage() {
		return schoolImage;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setRatingAndReviewsList(List<RatingAndReview> ratingAndReviewsList) {
		this.ratingAndReviewsList = ratingAndReviewsList;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	public void setSnippet(String snippet) {
		this.snippet = snippet;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setAverageRating(int averageRating) {
		this.averageRating = averageRating;
	}

	public void setSchoolImage(MultipartFile schoolImage) {
		this.schoolImage = schoolImage;
	}
	
	

	
	

}
