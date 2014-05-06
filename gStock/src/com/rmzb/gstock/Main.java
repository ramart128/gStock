package com.rmzb.gstock;

import java.io.File;
import java.sql.SQLException;

import com.rmzb.gstock.db.ConnectionHandler;

public final class Main {

	public static void main(String[] args) {
		System.out.println("gStock Version : 0.1");
		File dir = new File(System.getProperty("user.home") + File.separator
				+ "gStock");
		try {
			ConnectionHandler cnh = new ConnectionHandler(dir, true);
			cnh.getConnection().close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
