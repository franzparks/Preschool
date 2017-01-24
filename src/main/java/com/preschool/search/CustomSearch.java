/**
 * 
 */
package com.preschool.search;

import static com.google.common.base.CharMatcher.WHITESPACE;
import static com.google.common.base.Strings.isNullOrEmpty;
import static java.lang.String.format;
import static org.apache.commons.lang.StringUtils.isBlank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;

import com.google.gson.Gson;
import com.preschool.domain.MetaData;
import com.preschool.domain.Queries;
import com.preschool.domain.Result;
import com.preschool.domain.School;

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
	
	private String getUri(String query) {
		return format("https://www.googleapis.com/customsearch/v1?key=%s&cx=%s&q=%s&start=%d&alt=json",  
						getApiKey(), 
						getCx(), 
					WHITESPACE.trimAndCollapseFrom(query, '+'),
					getStart());
	}
	
	private HttpResponse getResponse(String query) {
		String uri = getUri(query);

		//HttpClient client = new DefaultHttpClient();
		//HttpClient client = HttpClients.createDefault();
		HttpClient client = HttpClientBuilder.create().build();
				
		HttpGet request = new HttpGet(uri);
		request.addHeader("accept", "application/json");

		try {
			return client.execute(request);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	private String getJson(HttpResponse response) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			String output;
			String json = "";
			
			while ((output = br.readLine()) != null) { json = json.concat(output); }

			return json;
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public Result execute(String query) {
				
		Result result = getSearchResult(query);
	
		if (result.getItems().size() < getNum()) {
			List<School> schools = getSearchResult(query).getItems();
			
			for (School school : schools) {
				
				if (result.getItems().size() < getNum()) { result.getItems().add(school); }
			}
		} else {			
			result.getItems().subList(getNum(), result.getItems().size()).clear();
		}

		return result;
	}
	
	/*
	 * Some items are not a web page. They could be images or something else. Here is where we remove them.
	 */
	private Result filterItems(Result result) {

		Iterator<School> schools = result.getItems().iterator();
		
		while (schools.hasNext()) {
			if (isBlank(schools.next().getFormattedUrl())) { schools.remove(); }
		}
		
		return result;
	}
	
	private Result getSearchResult(String query) {
		HttpResponse response = getResponse(query);
		String json = getJson(response);
		Queries queries = new MetaData(json).getQueries();
		setStart(queries.getNextPage().get(0).getStartIndex());
		
		return filterItems(new Gson().fromJson(json, Result.class));
	}
	
	public String getCx() {
		return cx;
	}

	public void setCx(String cx) {
		this.cx = cx;
	}

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public int getNum() {
		return this.num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	public int getStart() {
		return start;
	}
	
	public void setStart(int start) {
		this.start = start;
	}

}
