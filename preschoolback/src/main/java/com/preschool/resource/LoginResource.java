/**
 * 
 */
package com.preschool.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.preschool.service.UserService;

/**
 * @author francisphiri
 *
 */
@RestController
public class LoginResource {
	
	@Autowired
	private UserService userService;
	
}
