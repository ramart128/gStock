package com.rmzb.gstock.db;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConnectionHandler {

	/**
	 * 
	 */
	private static final String DERBY_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
	
	/**
	 * 
	 */
	private Connection connection = null;
	
	/**
	 * 
	 * @param folder
	 * @param create
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public ConnectionHandler(Folder folder, boolean create) throws ClassNotFoundException, SQLException {
		if(folder == null) {
			throw new IllegalArgumentException("Folder can't not be null");
		}
		
		StringBuilder url = new StringBuilder();
		url.append("jdbc:derby:");
		url.append(folder.getLocation() + File.separator +folder.getName());
		url.append(";create=");
		url.append(create);
		Class.forName(DERBY_DRIVER);
		this.connection = DriverManager.getConnection(DERBY_DRIVER);
	}

	/**
	 * 
	 * @return
	 */
	public Connection getConnection() {
		return connection;
	}
	
}
