/**
 * 
 */
package com.preschool.resource;

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
    public String bookList() {
		return "[ { id: 1, name: 'Zambia', author: 'Francis Phiri' } ]";
	}

}
