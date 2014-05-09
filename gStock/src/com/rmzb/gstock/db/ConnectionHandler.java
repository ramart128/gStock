package com.rmzb.gstock.db;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
	public ConnectionHandler(Folder folder, boolean create)
			throws ClassNotFoundException, SQLException {
		if (folder == null) {
			throw new IllegalArgumentException("Folder can't not be null");
		}

		StringBuilder url = new StringBuilder();
		url.append("jdbc:derby:");
		url.append(folder.getLocation() + File.separator + folder.getName());
		url.append(";create=");
		url.append(create);
		Class.forName(DERBY_DRIVER);
		if (create == true) {
			this.connection = DriverManager.getConnection(url.toString());
			setBuiltUserAuth();
		} else {
			this.connection = DriverManager.getConnection(url.toString(),
					"admin", "ajaxj3x9");
		}
	}

	/**
	 * @throws SQLException
	 * 
	 */
	private void setBuiltUserAuth() throws SQLException {
		String setProperty = "CALL SYSCS_UTIL.SYSCS_SET_DATABASE_PROPERTY(";
		String getProperty = "VALUES SYSCS_UTIL.SYSCS_GET_DATABASE_PROPERTY(";
		String requireAuth = "'derby.connection.requireAuthentication'";
		String defaultConnMode = "'derby.database.defaultConnectionMode'";
		String fullAccessUsers = "'derby.database.fullAccessUsers'";
		String provider = "'derby.authentication.provider'";

		Statement s = connection.createStatement();

		s.executeUpdate(setProperty + requireAuth + ", 'true')");

		ResultSet rs = s.executeQuery(getProperty + requireAuth + ")");
		rs.next();

		s.executeUpdate(setProperty + provider + ", 'BUILTIN')");

		s.executeUpdate(setProperty + "'derby.user.admin', 'ajaxj3x9')");

		s.executeUpdate(setProperty + fullAccessUsers + ", 'admin')");

		s.executeUpdate(setProperty + defaultConnMode + ", 'noAccess')");

		rs = s.executeQuery(getProperty + defaultConnMode + ")");
		rs.next();

		rs = s.executeQuery(getProperty + fullAccessUsers + ")");
		rs.next();

		s.executeUpdate("CALL SYSCS_UTIL.SYSCS_SET_DATABASE_PROPERTY("
				+ "'derby.database.propertiesOnly', 'false')");
		s.close();
	}

	/**
	 * 
	 * @return
	 */
	public Connection getConnection() {
		return connection;
	}

}
