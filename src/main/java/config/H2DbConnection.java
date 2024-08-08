package config;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.h2.tools.RunScript;

public class H2DbConnection {

	private static final String databaseUrl = "jdbc:h2:mem:testdb";
	private static final String username = "sa";
	private static final String password = "";
	private Connection connection;
	
	public Connection getConnection(){
		if(connection == null)
			createConnection();
		return connection;
	}
	
	private void createConnection(){
		Properties connectionProps = new Properties();
		connectionProps.put("user", username);
		connectionProps.put("password", password);
		connectionProps.put("serverTimezone","UTC");
		
		try {
			this.connection = DriverManager.getConnection(databaseUrl, connectionProps);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	
	public void initH2Database() {
		try {
			RunScript.execute(getConnection(),  new FileReader("./sql/createDatabase.sql"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
