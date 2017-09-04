/**
 * 
 */
package com.preschool.service;

import java.util.Set;

import com.preschool.domain.User;
import com.preschool.domain.security.UserRole;

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
