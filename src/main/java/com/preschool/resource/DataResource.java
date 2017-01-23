/**
 * 
 */
package com.preschool.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author francis
 *
 */

@RestController
@RequestMapping("/api")
public class DataResource {
	
	@RequestMapping(value = "/bookList", method = RequestMethod.GET)
    public List<String> bookList() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("{ id: 1, name: 'Zambia', author: 'Francis Phiri' }");
		return list;
	}

}
