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
@RequestMapping("/api")
public class DataResource {
	
	@RequestMapping(value = "/schoolList", method = RequestMethod.GET)
    public List<School> bookList() {
		ArrayList<School> list = new ArrayList<School>();
		list.add(new School(1L,"Montesorri", "Welcome to the best Montesorri",
				"https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcQ3U0wfMv-GMFQLjACk-nf_b1pdbpDHQkiviiAGyy8L0MZK2gUQeKjbSE3e"));
		list.add(new School(2L,"Harker", "Welcome to Harker",
				"https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcQ3U0wfMv-GMFQLjACk-nf_b1pdbpDHQkiviiAGyy8L0MZK2gUQeKjbSE3e"));
		return list;
	}

}
