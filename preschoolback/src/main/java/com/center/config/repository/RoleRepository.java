/**
 * 
 */
package com.center.config.repository;

import org.springframework.data.repository.CrudRepository;

import com.center.domain.security.Role;

/**
 * @author francisphiri
 *
 */
public interface RoleRepository extends CrudRepository<Role, Long>{
	
}
