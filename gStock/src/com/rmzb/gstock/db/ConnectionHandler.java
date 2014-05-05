package com.rmzb.gstock.db;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * @author Ramzi
 *
 */

public final class ConnectionHandler {

	/**
	 * 
	 */
	private static final String DERBY_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";

	/**
	 * 
	 */
	private Connection con = null;

	/**
	 * 
	 */
	private File db;

	/**
	 * 
	 * @param dir
	 * @param create
	 * @param username
	 * @param password
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public ConnectionHandler(File dir, boolean create, String username,
			String password) throws ClassNotFoundException, SQLException {
		if (dir == null) {
			throw new IllegalArgumentException("Directory must not be null");
		}
		
		this.db = dir;

		StringBuilder url = new StringBuilder();
		url.append("jdbc:derby:");
		url.append(db.getAbsolutePath());
		url.append(";create=");
		url.append(create);
		if (username != null && password != null) {
			url.append(";username=");
			url.append(username);
			url.append(";password=");
			url.append(password);
		}

		Class.forName(DERBY_DRIVER);
		this.con = DriverManager.getConnection(url.toString());
	}

	/**
	 * 
	 * @param dir
	 * @param create
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public ConnectionHandler(File dir, boolean create)
			throws ClassNotFoundException, SQLException {
		this(dir, create, null, null);
	}

	/**
	 * 
	 * @return
	 */
	public Connection getConnection() {
		return con;
	}

}
