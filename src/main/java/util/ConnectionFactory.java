package util;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;

public class ConnectionFactory {
	
	public static final String  DRIVER =  "com.mysql.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/todo";
	public static final String USER = "root";
	public static final String PASS = "";
	
	public static Connection getConnection() {
		try {
			Class.forName(DRIVER);
			return DriverManager.getConnection(URL, USER, PASS);
		} catch (Exception ex){
			throw new RuntimeException("Erro na conexção com o banco de dados", ex);
		}
	}
	
	public static void closeConnetion(Connection connection ) {
		try {
			if(connection != null) {
				connection.close();
			}
		} catch(Exception ex) {
			throw new RuntimeException("Erro ao fechar a conexão com o banco de dados", ex);
		}
	}
	
	public static void closeConnetion(Connection connection, PreparedStatement statement) {
		try {
			if(connection != null) {
				connection.close();
			}
			if(statement != null) {
				statement.close();
			}
		} catch(Exception ex) {
			throw new RuntimeException("Erro ao fechar a conexão com o banco de dados", ex);
		}
	}
	
	public static void closeConnetion(Connection connection, PreparedStatement statement, ResultSet result ) {
		try {
			if(connection != null) {
				connection.close();
			}
			if(statement != null) {
				statement.close();
			}
			if(result != null) {
				result.close();
			}
			
		} catch(Exception ex) {
			throw new RuntimeException("Erro ao fechar a conexão com o banco de dados", ex);
		}
	}

}
