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
	
	private String getUri(String query) {
		return format("https://www.googleapis.com/customsearch/v1?key=%s&cx=%s&q=%s&start=%d&alt=json",  
						getApiKey(), 
						getCx(), 
					WHITESPACE.trimAndCollapseFrom(query, '+'),
					getStart());
	}
	
	private HttpResponse getResponse(String query) {
		String uri = getUri(query);

		HttpClient client = new DefaultHttpClient();
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
			List<Item> items = getSearchResult(query).getItems();
			
			for (Item item : items) {
				
				if (result.getItems().size() < getNum()) { result.getItems().add(item); }
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
		Iterator<Item> items = result.getItems().iterator();
		
		while (items.hasNext()) {
			if (isBlank(items.next().getFormattedUrl())) { items.remove(); }
		}
		
		return result;
	}
	
	private Result getSearchResult(String query) {
		HttpResponse response = getResponse(query);
		String json = getJson(response);

		Queries queries = new Meta(json).getQueries();
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
		return num;
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
