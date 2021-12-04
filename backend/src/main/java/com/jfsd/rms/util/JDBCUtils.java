/**
 * 
 */
package com.jfsd.rms.util;

import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

import org.h2.jdbcx.JdbcConnectionPool;

/**
 * @author madan
 *
 */
public class JDBCUtils {
	
	private static volatile JDBCUtils datasource;
	private JdbcConnectionPool connectionPool;
	
	private static final String PROPERTIES_FILE_PATH="src/main/resources/DBConfig.properties";
	
	public static void closeConnection(Connection con) throws RMSException {
		try {
			if (con != null) {
				con.close();
			}
		} catch (Exception e) {
			throw new RMSException("Failed to close DB Connection : " + e.getMessage());
		}
	}
	
	private JDBCUtils() throws RMSException {
		try (FileInputStream inputStream = new FileInputStream(PROPERTIES_FILE_PATH)) {
			Properties properties = new Properties();
			properties.load(inputStream);
			connectionPool = JdbcConnectionPool.create(properties.get("url").toString(), properties.get("user").toString(), properties.get("password").toString());
		} catch (Exception e) {
			throw new RMSException("Failed to create DB Connection Pool : " + e.getMessage());
		}
	}
	
	public Connection getConnection() throws RMSException {
        try {
			return connectionPool.getConnection();
		} catch (Exception e) {
			throw new RMSException("Failed to get DB Connection : " + e.getMessage());
		}
    }
	
	public static JDBCUtils getInstance() throws RMSException {
		try {
			if (datasource == null) {
	            synchronized (JDBCUtils.class) {
	                if (datasource == null) {
	                	datasource = new JDBCUtils();
	                }
	            }
	        }
	        return datasource;
		} catch (Exception e) {
			throw new RMSException("Failed to Create DB Connection Pool : " + e.getMessage());
		}
    }
}
