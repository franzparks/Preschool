/**
 * 
 */
package com.center.domain.security;

import java.io.Serializable;

import org.springframework.security.core.GrantedAuthority;

/**
 * @author francisphiri
 *
 */
public class Authority implements GrantedAuthority, Serializable{
	
	private static final long serialVersionUID = 123123L;
	
	private final String authority;
	
	public Authority(String authority) {
		this.authority = authority;
	}
	
	@Override
	public String getAuthority() {
		return authority;
	}
	
}
