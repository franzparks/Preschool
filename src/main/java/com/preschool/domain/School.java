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
	 * @param title
	 * @param link
	 * @param snippet
	 * @param formattedUrl
	 */
	
	private String title;
	private String link;
	private String snippet;
	private String formattedUrl;
	
	
	/*public School(String title, String link, String snippet, String formattedUrl) {
		super();
		this.title = title;
		this.link = link;
		this.snippet = snippet;
		this.formattedUrl = formattedUrl;
	}*/
	
	
	public School(){}

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
