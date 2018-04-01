/**
 * 
 */
package com.center.config.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.repository.CrudRepository;

import com.center.domain.Center;

/**
 * @author francisphiri
 *
 */
public interface CenterRepository extends CrudRepository<Center, Long>{
	
	List<Center> findByNameContaining(String keyword);
	
	//fetch reviews
	@EntityGraph(value = "Center.detail", type = EntityGraphType.LOAD)
	List<Center> findAll();
}
