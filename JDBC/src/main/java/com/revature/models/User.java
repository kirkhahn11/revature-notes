package com.revature.models;


import java.io.Serializable;
import java.util.List;

public class User implements Serializable {

	//hover over class name to add serialversionID
	private static final long serialVersionUID = -4553508689874995351L;
	private int id; //be represented in our DB as a PRIMARY KEY (and SERIAL)
	private String username;
	private String password;
	private Role role;
	private List<Account> accounts;
	
	public User() {
		super();
	}

	public User(String username, String password, List<Account> accounts, Role role) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.accounts = accounts;
		this.role = role;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	// This allows us to create a User from within in the "business layer" == created in JAVA
	// We can send it to the DB, get an ID and add it once the DB sends the account back
	public User(int id, String username, String password, Role role, List<Account> accounts) {
		super();
		this.username = username;
		this.password = password;
		this.accounts = accounts;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof User))
			return false;
		User other = (User) obj;
		if (id != other.id)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + "]";
	}
	
	
	
}
