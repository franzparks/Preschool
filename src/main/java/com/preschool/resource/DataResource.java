/**
 * 
 */
package com.preschool.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.preschool.domain.Result;
import com.preschool.domain.School;
import com.preschool.search.CustomSearch;

/**
 * @author francis
 *
 */

@RestController
@RequestMapping("/api")
public class DataResource {
	
	@RequestMapping(value = "/schoolList", method = RequestMethod.GET)
    public List<School> bookList() {
		ArrayList<School> list = new ArrayList<School>();
		
		String cx = "014723624719242706501:ky6zn2teax4";
	    String apiKey = "AIzaSyBFnKBQPESdi2sP1twKp59-3mBscTVw99k";
	    CustomSearch $ = new CustomSearch(cx, apiKey, 10);
	    
		Result result = $.execute("Preschools");
		list.addAll(result.getItems());
		return list;
	}

}
