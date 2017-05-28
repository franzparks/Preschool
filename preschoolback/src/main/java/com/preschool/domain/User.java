/**
 * 
 */
package com.preschool.domain;

import java.io.Serializable;

import javax.persistence.Entity;

import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author francisphiri
 *
 */
@Entity
public class User implements UserDetails, Serializable{
	
}
