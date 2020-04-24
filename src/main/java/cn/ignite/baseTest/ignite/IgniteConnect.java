package cn.ignite.baseTest.ignite;

import java.sql.Connection;
import java.sql.DriverManager;

public class IgniteConnect {
	public static Connection getConnect() throws Exception {
		// Register JDBC driver.
		Class.forName("org.apache.ignite.IgniteJdbcThinDriver");
		// Open JDBC connection.
		Connection conn = DriverManager.getConnection("jdbc:ignite:thin://127.0.0.1/");
		return conn;
	}

}
