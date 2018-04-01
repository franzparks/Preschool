/**
 * 
 */
package com.center.domain;

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
@NamedEntityGraph(name = "Center.detail",
attributeNodes = @NamedAttributeNode("ratingAndReviewsList"))
public class Center implements Serializable{
	
	private static final long serialVersionUID=425345L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@OneToMany(mappedBy = "center", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<RatingAndReview> ratingAndReviewsList;
	
	private String name;
	private String type;
	private String category;
	private String teacherToStudentRatio;
	private String ageRange;
	private String priceRange;
	private String schedule;
	private String address;
	private String phone;
	private String website;
	@Column(columnDefinition="text")
	private String summary;
	private int averageRating;
	
	@Transient
	private MultipartFile centerImage;

	public Long getId() {
		return id;
	}

	public List<RatingAndReview> getRatingAndReviewsList() {
		return ratingAndReviewsList;
	}
	public String getTeacherToStudentRatio() {
		return teacherToStudentRatio;
	}
	
	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public String getCategory() {
		return category;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setCategory(String category) {
		this.category = category;
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

	public MultipartFile getCenterImage() {
		return centerImage;
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

	public void setCenterImage(MultipartFile centerImage) {
		this.centerImage = centerImage;
	}

	@Override
    public String toString() {
	    return "Center [id=" + id + ", ratingAndReviewsList="
	            + ratingAndReviewsList + ", name=" + name + ", type=" + type
	            + ", category=" + category + ", teacherToStudentRatio="
	            + teacherToStudentRatio + ", ageRange=" + ageRange
	            + ", priceRange=" + priceRange + ", schedule=" + schedule
	            + ", address=" + address + ", phone=" + phone + ", website="
	            + website + ", summary=" + summary + ", averageRating="
	            + averageRating + "]";
    }

	
	
}

