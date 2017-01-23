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

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getLink() {
		return link;
	}

	public String getSnippet() {
		return snippet;
	}

	public String getFormattedUrl() {
		return formattedUrl;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public void setSnippet(String snippet) {
		this.snippet = snippet;
	}

	public void setFormattedUrl(String formattedUrl) {
		this.formattedUrl = formattedUrl;
	}
	

}
