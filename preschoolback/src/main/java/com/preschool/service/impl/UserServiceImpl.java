/**
 * 
 */
package com.preschool.service.impl;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.preschool.config.repository.UserRepository;
import com.preschool.domain.User;
import com.preschool.domain.security.UserRole;
import com.preschool.service.UserService;

/**
 * @author francisphiri
 *
 */
@Service
public class UserServiceImpl implements UserService{

	private static final Logger LOG = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserRepository userRepository;
	
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
