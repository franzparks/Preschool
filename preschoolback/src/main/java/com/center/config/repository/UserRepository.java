/**
 * 
 */
package com.center.config.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.center.domain.User;

/**
 * @author francisphiri
 *
 */
public interface UserRepository extends CrudRepository<User, Long>{
	User findByUsername(String username);
	User findByEmail(String email);
	List<User> findAll();
}
