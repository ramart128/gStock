/**
 * 
 */
package com.rmzb.gstock.db.objects;

/**
 * @author Ramzi
 *
 */
public final class User {
	
	/**
	 * 
	 */
	private String username;
	
	/**
	 * 
	 */
	private String password;
	
	/**
	 * 
	 * @param username
	 * @param password
	 */
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	/**
	 * 
	 * @return
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * 
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
