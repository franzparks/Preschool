/**
 * 
 */
package com.preschool.domain;

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
	@JoinColumn(name="school_id")
	@JsonIgnore
	private School school;
	
	@ManyToOne
	private User user;
	
	private String message;
	
	private Date date;
	
	private int givenSchoolId;
	
	
	public Long getId() {
		return id;
	}
	public School getSchool() {
		return school;
	}
	public User getUser() {
		return user;
	}
	public String getMessage() {
		return message;
	}
	public Date getDate() {
		return date;
	}
	
	public int getGivenSchoolId(){
		return this.givenSchoolId;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setSchool(School school) {
		this.school = school;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public void setGivenSchoolId(int givenSchoolId){
		this.givenSchoolId = givenSchoolId;
	}
	
	
	
	
	
}
