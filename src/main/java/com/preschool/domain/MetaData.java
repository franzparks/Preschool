/**
 * 
 */
package com.preschool.domain;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

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
		
		private String getJson() {
			return json;
		}
		
		private void setJson(String json) {
			this.json = json;
		}
		
		private JsonObject getJsonObject() {
			return new JsonParser().parse(getJson()).getAsJsonObject();
		}
		
		private void setQueries() {
			queries = new Gson().fromJson(getJsonObject().get("queries"), Queries.class);
		}
		
		public Queries getQueries() {
			return queries;
		}

}
