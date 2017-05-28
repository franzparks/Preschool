/**
 * 
 */
package com.preschool.domain;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author francisphiri
 *
 */
public class RatingAndReview {
	
private static final long serialVersionUID=425345L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="school_id")
	@JsonIgnore
	private School school;
	
	@OneToOne
	private User user;
	
	private String message;
	private Date date;
	
	
	
}
