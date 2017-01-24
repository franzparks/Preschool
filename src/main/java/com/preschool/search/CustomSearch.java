package com.preschool.search;

import com.preschool.domain.Result;

public interface CustomSearch {

	Result execute(String query);

	String getCx();

	void setCx(String cx);

	String getApiKey();

	void setApiKey(String apiKey);

	int getNum();

	void setNum(int num);

	int getStart();

	void setStart(int start);

}