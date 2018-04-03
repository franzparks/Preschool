/**
 * 
 */
package com.center.service;

import java.util.Set;

import com.center.domain.security.UserRole;
import com.center.domain.User;

/**
 * @author francisphiri
 *
 */
public interface UserService {
	
	User createUser(User user, Set<UserRole> userRoles);

	User findByUsername(String username);
	
	User findByEmail (String email);
	
	User save(User user);
	
	User findById(Long id);
}
