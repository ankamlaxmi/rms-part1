package com.jfsd.rms.util;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.util.Properties;

public class OracleCon {
	public static Connection openConnection() throws RMSException {
		Connection con = null;
		try {
			// Class.forName("oracle.jdbc.driver.OracleDriver");
			// con=DriverManager.getConnection("jdbc:oracle:thin:@10.44.66.47:1521:cmsdemo","epsuser","epsuser");
			Properties p = new Properties();
			FileInputStream fis = new FileInputStream("src/main/resources/MyDriverDetails.properties");
			p.load(fis);
			Driver d = (Driver) Class.forName((String) p.get("driverClassName")).newInstance();
			con = d.connect((String) p.get("url"), p);
		} catch (Exception e) {
			throw new RMSException("Failed to open DB Connection : " + e.getMessage());
		}
		return con;
	}

	public static void closeConnection(Connection con) throws RMSException {
		try {
			if (con != null) {
				con.close();
			}
		} catch (Exception e) {
			throw new RMSException("Failed to close DB Connection : " + e.getMessage());
		}
	}
}