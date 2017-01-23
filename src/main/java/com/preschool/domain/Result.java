
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
	private List<School> schools;
	
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
	public List<School> getSchools() {
		return schools;
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
	public void setSchools(List<School> schools) {
		this.schools = schools;
	}
	
	

}
