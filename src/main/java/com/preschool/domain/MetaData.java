/**
 * 
 */
package com.preschool.domain;

/**
 * @author francis
 *
 */
public class MetaData {
	
	private String json;
	private Queries queries;
	
	public MetaData(String json) {
		setJson(json);
		setQueries();
	}

}
