/**
 * 
 */
package com.preschool.domain;

import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author francis
 *
 */
public class School {
	
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
