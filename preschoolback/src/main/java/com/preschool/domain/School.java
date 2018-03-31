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
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author francis
 *
 */

@Entity
@NamedEntityGraph(name = "School.detail",
attributeNodes = @NamedAttributeNode("ratingAndReviewsList"))
public class School implements Serializable{
	
	private static final long serialVersionUID=425345L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@OneToMany(mappedBy = "school", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JsonIgnore
	private List<RatingAndReview> ratingAndReviewsList;
	
	private String title;
	@Column(columnDefinition="text")
	private String summary;
	private String teacherToStudentRatio;
	private String ageRange;
	private String priceRange;
	private String schedule;
	private String address;
	private String phone;
	private String website;
	private int averageRating;
	
	@Transient
	private MultipartFile schoolImage;

	public Long getId() {
		return id;
	}

	public List<RatingAndReview> getRatingAndReviewsList() {
		return ratingAndReviewsList;
	}
	public String getTeacherToStudentRatio() {
		return teacherToStudentRatio;
	}
	public String getTitle() {
		return title;
	}

	public String getSummary() {
		return summary;
	}
	
	public String getAgeRange() {
		return ageRange;
	}

	public String getPriceRange() {
		return priceRange;
	}
	
	public String getSchedule() {
		return schedule;
	}

	public String getAddress() {
		return address;
	}

	public String getPhone() {
		return phone;
	}
	
	public String getWebsite() {
		return website;
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
	public void setTeacherToStudentRatio(String teacherToStudentRatio) {
		this.teacherToStudentRatio = teacherToStudentRatio;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}
	
	public void setAgeRange(String ageRange) {
		this.ageRange = ageRange;
	}

	public void setPriceRange(String priceRange) {
		this.priceRange = priceRange;
	}
	
	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public void setWebsite(String website) {
		this.website = website;
	}

	public void setAverageRating(int averageRating) {
		this.averageRating = averageRating;
	}

	public void setSchoolImage(MultipartFile schoolImage) {
		this.schoolImage = schoolImage;
	}

	@Override
    public String toString() {
	    return "School Id : " + id + ", Rating And Reviews List : [ "
	            + ratingAndReviewsList + "], Teacher To Student Ratio : "+teacherToStudentRatio+ ", Title " + title + ", Age Range : "
	            + ageRange + ", Price Range : " + priceRange + ", Summary : " + summary
	            + ", Address : " + address + ", Phone : " + phone + ", Website : "+ website
	            + ", Average Rating : " + averageRating + ", School Image : "
	            + schoolImage;
    }
	
}

