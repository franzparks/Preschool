package com.preschool.search;

import org.springframework.stereotype.Component;

import com.preschool.domain.Result;

@Component
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