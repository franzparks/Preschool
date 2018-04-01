/**
 * 
 */
package com.center.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author francisphiri
 *
 */
@Entity
@Table(name = "user_review")
public class RatingAndReview {
	
private static final long serialVersionUID=425345L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="center_id")
	@JsonIgnore
	private Center center;
	
	@ManyToOne
	@JsonIgnore
	private User user;
	
	private String message;
	
	private String reviewer;
	
	private Date date;
	
	private int givenCenterId;
	
	private int userRating;
	
	
	public Long getId() {
		return id;
	}
	public Center getCenter() {
		return center;
	}
	public User getUser() {
		return user;
	}
	public String getMessage() {
		return message;
	}
	public String getReviewer() {
		return reviewer;
	}
	public Date getDate() {
		return date;
	}
	
	public int getGivenCenterId(){
		return this.givenCenterId;
	}
	
	public int getUserRating(){
		return this.userRating;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public void setCenter(Center center) {
		this.center = center;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setReviewer(String reviewer) {
		this.reviewer = reviewer;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public void setGivenCenterId(int givenCenterId){
		this.givenCenterId = givenCenterId;
	}
	
	public void setUserRating(int userRating){
		this.userRating = userRating;
	}
	
}
