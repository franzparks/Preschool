/**
 * 
 */
package com.preschool.search;

/**
 * @author francis
 *
 */
public class CustomSearch {
	
	private String cx;
	private String apiKey;
	private int num;
	private int start = 1;
	
	public CustomSearch(String cx, String apiKey, int num) {
		if (isNullOrEmpty(cx) || isNullOrEmpty(apiKey)) { throw new IllegalArgumentException("CX and API Key are required"); }
		
		setApiKey(apiKey);
		setCx(cx);
		setNum(num);
	}

}
