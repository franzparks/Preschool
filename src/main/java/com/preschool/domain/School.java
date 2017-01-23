/**
 * 
 */
package com.preschool.domain;

/**
 * @author francis
 *
 */
public class School {
	
	private Long id;
	private String title;
	private String snippet;
	private String imageUrl;
	
	/**
	 * @param id
	 * @param title
	 * @param snippet
	 * @param imageUrl
	 */
	public School(Long id, String title, String snippet, String imageUrl) {
		super();
		this.id = id;
		this.title = title;
		this.snippet = snippet;
		this.imageUrl = imageUrl;
	}
	public School(){}
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @return the snippet
	 */
	public String getSnippet() {
		return snippet;
	}
	/**
	 * @return the imageUrl
	 */
	public String getImageUrl() {
		return imageUrl;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @param snippet the snippet to set
	 */
	public void setSnippet(String snippet) {
		this.snippet = snippet;
	}
	/**
	 * @param imageUrl the imageUrl to set
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	
	

}
