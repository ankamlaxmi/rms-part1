/**
 * 
 */
package com.jfsd.rms.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author madan
 *
 */
public class CreateTableUtil {

	private static final String createTableSQL = "create table roommate (id  int, name varchar(25), address varchar(50), mobile varchar(10), dateOfJoining date);";

	public static void main(String[] argv) throws SQLException {
		CreateTableUtil createTable = new CreateTableUtil();
		try {
			createTable.create();
		} catch (RMSException e) {
			e.printStackTrace();
		}
	}

	public void create() throws RMSException {
		System.out.println(createTableSQL);
		// Step 1: Establishing a Connection
		try (Connection connection = JDBCUtils.getInstance().getConnection();
				// Step 2:Create a statement using connection object
				Statement statement = connection.createStatement();) {

			// Step 3: Execute the query or update query
			if (statement.execute(createTableSQL)) {
				System.out.println("Table Created Successfully");
			} else {
				System.out.println("Table creation failed");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
