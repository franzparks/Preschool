/**
 * 
 */
package com.preschool.config.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.repository.CrudRepository;

import com.preschool.domain.School;

/**
 * @author francisphiri
 *
 */
public interface SchoolRepository extends CrudRepository<School, Long>{
	
	List<School> findByTitleContaining(String keyword);
	
	//fetch reviews
	@EntityGraph(value = "School.detail", type = EntityGraphType.LOAD)
	List<School> findAll();
}
