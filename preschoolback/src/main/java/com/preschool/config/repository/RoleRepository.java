/**
 * 
 */
package com.preschool.config.repository;

import org.springframework.data.repository.CrudRepository;

import com.preschool.domain.security.Role;

/**
 * @author francisphiri
 *
 */
public interface RoleRepository extends CrudRepository<Role, Long>{
	
}
