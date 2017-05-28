/**
 * 
 */
package com.preschool.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author francisphiri
 *
 */
@Service
public interface UserSecurityService implements UserDetailsService{
	
	private static final Logger LOG = LoggerFactory.getLogger(UserSecurityService.class);
	
}
