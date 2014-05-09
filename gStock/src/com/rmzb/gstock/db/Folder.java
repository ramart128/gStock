package com.rmzb.gstock.db;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;

public final class Folder {

	/**
	 * 
	 */
	private String name;

	/**
	 * 
	 */
	private String location;

	/**
	 * 
	 */
	private Connection connection = null;

	/**
	 * 
	 * @param dir
	 * @param create
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public Folder(File dir, boolean create) throws ClassNotFoundException,
			SQLException {

		if (dir == null) {
			throw new IllegalArgumentException("Folder can't be null");
		}

		this.name = dir.getName();
		this.location = dir.getAbsolutePath();

		ConnectionHandler cHandler = new ConnectionHandler(this, create);
		connection = cHandler.getConnection();
	}

	/**
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @return
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * 
	 * @return
	 */
	public Connection getConnection() {
		return connection;
	}

}
