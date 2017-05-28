/**
 * 
 */
package com.preschool.service.impl;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.preschool.domain.User;
import com.preschool.domain.security.UserRole;
import com.preschool.service.UserService;

/**
 * @author francisphiri
 *
 */
@Service
public class UserServiceImpl implements UserService{

	@Override
    public User createUser(User user, Set<UserRole> userRoles) {
	    // TODO Auto-generated method stub
	    return null;
    }

	@Override
    public User findByUsername(String username) {
	    // TODO Auto-generated method stub
	    return null;
    }

	@Override
    public User findByEmail(String email) {
	    // TODO Auto-generated method stub
	    return null;
    }

	@Override
    public User save(User user) {
	    // TODO Auto-generated method stub
	    return null;
    }

	@Override
    public User findById(Long id) {
	    // TODO Auto-generated method stub
	    return null;
    }
	
}
