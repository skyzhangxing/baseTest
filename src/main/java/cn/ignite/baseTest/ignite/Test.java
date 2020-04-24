package cn.ignite.baseTest.ignite;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test {
	public static void main(String[] args) throws Exception {
		Connection conn = IgniteConnect.getConnect();
		try (Statement stmt = conn.createStatement()) {

			try (ResultSet rs = stmt
					.executeQuery("SELECT id " + " FROM City")) {

				while (rs.next())
					System.out.println(rs.getString(1));
			}
		}
	}
}
