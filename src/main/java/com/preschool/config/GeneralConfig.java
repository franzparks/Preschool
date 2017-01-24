/**
 * 
 */
package com.preschool.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Configuration;

import com.preschool.domain.Result;
import com.preschool.domain.School;
import com.preschool.search.CustomSearch;
import com.preschool.search.CustomSearchImp;

/**
 * @author francis
 *
 */
@Configuration
public class GeneralConfig {
	
	private final String cx = "014723624719242706501:ky6zn2teax4";
    private final String apiKey = "AIzaSyBFnKBQPESdi2sP1twKp59-3mBscTVw99k";
	
	public CustomSearch makeCustomSearch(){
		
			ArrayList<School> list = new ArrayList<School>();
		
		    CustomSearch $ = new CustomSearchImp(cx, apiKey, 10);
		    
			Result result = $.execute("Santa Clara Preschools");
			list.addAll(result.getItems());
		
		return null;
	}

}
