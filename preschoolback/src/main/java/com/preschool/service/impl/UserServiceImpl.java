/**
 * 
 */
package com.preschool.service.impl;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.preschool.config.repository.RoleRepository;
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
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Transactional
	public User createUser(User user, Set<UserRole> userRoles) {
		
		User localUser = userRepository.findByUsername(user.getUsername());
		
		if(localUser != null) {
			LOG.info("User with username {} already exist. Nothing will be done. ", user.getUsername());
		} else {
			for (UserRole ur : userRoles) {
				roleRepository.save(ur.getRole());
			}
			
			user.getUserRoles().addAll(userRoles);
			
			localUser = userRepository.save(user);
		}
		
		return localUser;
	}

	@Override
    public User findByUsername(String username) {
	    return userRepository.findByUsername(username);
    }

	@Override
    public User findByEmail(String email) {
	    return userRepository.findByEmail(email);
    }

	@Override
    public User save(User user) {
	    return userRepository.save(user);
    }

	@Override
    public User findById(Long id) {
	    // TODO Auto-generated method stub
	    return null;
    }
	
}
