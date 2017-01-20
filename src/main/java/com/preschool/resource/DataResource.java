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
	
	@RequestMapping(value = "/schools/all", method = RequestMethod.GET)
    public String schoolsList() {
		return "[ { id: 1, name: 'Zambia', author: 'Francis Phiri' } ]";
	}

}
