/**
 * 
 */
package com.preschool.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.preschool.domain.security.UserRole;
import com.preschool.domain.security.Authority;

/**
 * @author francisphiri
 *
 */
@Entity
public class User implements UserDetails, Serializable{
	
private static final long serialVersionUID = 902783495L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Id", nullable=false, updatable = false)
	private Long id;
	
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	
	private String email;
	private String phone;
	private boolean enabled = true;
	
	@OneToMany(mappedBy = "user", cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonIgnore
	private Set<UserRole> userRoles = new HashSet<>();
	
	@OneToMany(mappedBy="user")
	private List<RatingAndReview> reviewsList;

	public Long getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public Set<UserRole> getUserRoles() {
		return userRoles;
	}

	public List<RatingAndReview> getReviewsList() {
		return reviewsList;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	public void setReviewsList(List<RatingAndReview> reviewsList) {
		this.reviewsList = reviewsList;
	}

	@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
		
		Set<GrantedAuthority> authorities = new HashSet<>();
		userRoles.forEach(ur -> authorities.add(new Authority(ur.getRole().getName())));
		
		return authorities;
    }

	@Override
    public boolean isAccountNonExpired() {
	    return true;
    }

	@Override
    public boolean isAccountNonLocked() {
	    return true;
    }

	@Override
    public boolean isCredentialsNonExpired() {
	    return true;
    }

	@Override
    public String toString() {
	    return "User [id=" + id + ", username=" + username + ", firstName="
	            + firstName + ", lastName=" + lastName + ", email=" + email
	            + ", phone=" + phone + "]";
    }

}
