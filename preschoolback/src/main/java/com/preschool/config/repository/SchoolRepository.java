/**
 * 
 */
package com.preschool.config.repository;

import org.springframework.data.repository.CrudRepository;

import com.preschool.domain.School;

/**
 * @author francisphiri
 *
 */
public interface SchoolRepository extends CrudRepository<School, Long>{
	
}
