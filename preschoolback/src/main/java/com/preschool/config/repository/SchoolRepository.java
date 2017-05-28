/**
 * 
 */
package com.preschool.config.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.preschool.domain.School;

/**
 * @author francisphiri
 *
 */
public interface SchoolRepository extends CrudRepository<School, Long>{
	List<School> findByTitleContaining(String keyword);
}
