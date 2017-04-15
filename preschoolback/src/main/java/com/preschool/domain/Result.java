
/**
 * 
 */
package com.preschool.domain;

import java.util.List;

/**
 * @author francis
 *
 */
public class Result {
	
	private SearchInformation searchInformation;
	private List<School> items;
	
	public Result() {}

	/**
	 * @return the searchInformation
	 */
	public SearchInformation getSearchInformation() {
		return searchInformation;
	}

	/**
	 * @return the schools
	 */
	public List<School> getItems() {
		return items;
	}

	/**
	 * @param searchInformation the searchInformation to set
	 */
	public void setSearchInformation(SearchInformation searchInformation) {
		this.searchInformation = searchInformation;
	}

	/**
	 * @param schools the schools to set
	 */
	public void setSchools(List<School> items) {
		this.items = items;
	}
	
	

}
