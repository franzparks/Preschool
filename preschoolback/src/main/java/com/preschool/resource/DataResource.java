/**
 * 
 */
package com.preschool.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.preschool.domain.School;

/**
 * @author francis
 *
 */

@RestController
//@RequestMapping("/api")
public class DataResource {
	
	//@Autowired
	//private CustomSearch search;
	
	@RequestMapping(value = "/schoolList", method = RequestMethod.GET)
    public List<School> schoolList() {
		ArrayList<School> list = new ArrayList<School>();

		return list;
	}

}
