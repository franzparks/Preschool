/**
 * 
 */
package com.preschool.domain;

/**
 * @author francis
 *
 */
public class School {
	
	/**
	 * @param id
	 * @param title
	 * @param link
	 * @param snippet
	 * @param formattedUrl
	 */
	public School(Long id, String title, String link, String snippet, String formattedUrl) {
		super();
		this.id = id;
		this.title = title;
		this.link = link;
		this.snippet = snippet;
		this.formattedUrl = formattedUrl;
	}
	private Long id;
	private String title;
	private String link;
	private String snippet;
	private String formattedUrl;
	
	
	
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
