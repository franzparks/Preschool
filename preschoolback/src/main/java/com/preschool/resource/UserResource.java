/**
 * 
 */
package com.preschool.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.preschool.service.UserService;
import com.preschool.utility.MailConstructor;

/**
 * @author francisphiri
 *
 */
@RestController
@RequestMapping("/user")
public class UserResource {
	
	@Autowired
	private UserService userService;

	@Autowired
	private MailConstructor mailConstructor;

	@Autowired
	private JavaMailSender mailSender;
	
}
