package cn.ignite.baseTest.ignite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class IgniteSQL {
	public static void main(String[] args) throws Exception {

	Connection conn = IgniteConnect.getConnect();

		// Create database tables.
		try (Statement stmt = conn.createStatement()) {

			// Create table based on REPLICATED template.
			stmt.executeUpdate(
					"CREATE TABLE City (" + " id Int PRIMARY KEY, name VARCHAR) " + " WITH \"template=replicated\"");

			/*// Create table based on PARTITIONED template with one backup.
			stmt.executeUpdate("CREATE TABLE Person (" + " id LONG, name VARCHAR, city_id LONG, "
					+ " PRIMARY KEY (id, city_id)) " + " WITH \"backups=1, affinityKey=city_id\"");

			// Create an index on the City table.
			stmt.executeUpdate("CREATE INDEX idx_city_name ON City (name)");

			// Create an index on the Person table.
			stmt.executeUpdate("CREATE INDEX idx_person_name ON Person (name)");*/
		}

		// Populate City table
		try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO City (id, name) VALUES (?, ?)")) {
			for (int i = 0; i < 100; i++) {
				stmt.setLong(1, i);
				stmt.setString(2, "Forest Hill");
				stmt.executeUpdate();
			}
		}
		
	}
}
