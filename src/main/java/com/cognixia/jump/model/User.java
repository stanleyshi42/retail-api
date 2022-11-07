package com.cognixia.jump.model;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {
	public static enum Role {
		ROLE_USER, ROLE_ADMIN, ROLE_DEV
	}

	@Id
	private String id;

	@Indexed(unique = true)
	@NotBlank
	private String username;

	@NotBlank
	private String password;

	@Valid
	private Address address;

	@NotBlank
	private Role role;

	@NotBlank
	private boolean enabled;

	public User() {

	}

	public User(String id, @NotBlank String username, @NotBlank String password, Address address, Role role,
			boolean enabled) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.address = address;
		this.role = role;
		this.enabled = enabled;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", address=" + address
				+ ", role=" + role + ", enabled=" + enabled + "]";
	}

}
