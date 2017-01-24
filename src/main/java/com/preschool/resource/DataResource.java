/**
 * 
 */
package com.preschool.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.preschool.domain.Result;
import com.preschool.domain.School;
import com.preschool.search.CustomSearch;
import com.preschool.search.CustomSearchImp;

/**
 * @author francis
 *
 */

@RestController
@RequestMapping("/api")
public class DataResource {
	
	@Autowired
	private CustomSearch search;
	
	@RequestMapping(value = "/schoolList", method = RequestMethod.GET)
    public List<School> bookList() {
		ArrayList<School> list = new ArrayList<School>();
		
		if(list.size() < 1){
			
			Result result = search.execute("Santa Clara Preschools");
			list.addAll(result.getItems());
		}
		
		return list;
	}

}
