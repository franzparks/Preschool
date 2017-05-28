/**
 * 
 */
package com.preschool.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author francis
 *
 */

@Entity
public class School implements Serializable{
	
	private static final long serialVersionUID=425345L;
	
	private Long id;
	private String title;
	private String subTitle;
	private String snippet;
	private String summary;
	private String address;
	private String phone;
	private int averageRating;
	
	@Transient
	private MultipartFile schoolImage;

	
	

}
