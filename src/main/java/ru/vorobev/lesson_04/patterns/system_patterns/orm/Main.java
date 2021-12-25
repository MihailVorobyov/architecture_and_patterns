package ru.vorobev.lesson_04.patterns.system_patterns.orm;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Main {
	
	public static void main(String[] args) {
		Connection connection = null;
		try {
			connection = getConnection();
			UserRepository userRepository = new UserRepository(connection);
			
			User user = userRepository.findById(1);
			System.out.println(user);
			
			int id1 = 20;
			int id2 = 21;
			
			// =====================================================================
			System.out.println("============================Insert new users============================");
			userRepository.beginTransaction();
			userRepository.insert(new User(0, "User" + id1, "Passwd" + id1));
			userRepository.insert(new User(0, "User" + id2, "Passwd" + id2));
			userRepository.commit();
			
			System.out.println(userRepository.findById(id1));
			System.out.println(userRepository.findById(id2));
			// =====================================================================
			System.out.println("============================Update users============================");
			
			userRepository.beginTransaction();
			userRepository.update(new User(id1, "User" + id1 + "-new", "Passwd" + id1 + "-new"));
			userRepository.update(new User(id2, "User" + id2 + "-new", "Passwd" + id2 + "-new"));
			userRepository.commit();
			
			System.out.println(userRepository.findById(id1));
			System.out.println(userRepository.findById(id2));
			// =====================================================================
			System.out.println("============================Delete users============================");
			
			userRepository.beginTransaction();
			userRepository.delete(userRepository.findById(id1));
			userRepository.delete(userRepository.findById(id2));
			userRepository.commit();
			
			System.out.println("============================Users should be null============================");
			System.out.println(userRepository.findById(id1));
			System.out.println(userRepository.findById(id2));
			
		} catch (SQLException | IOException throwables) {
			throwables.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	private static Connection getConnection() throws SQLException, IOException {
		
		Properties props = new Properties();
		try(InputStream in = Files.newInputStream(Paths.get("src/main/resources","connection.properties"))){
			props.load(in);
		}
		String url = props.getProperty("url");
		String username = props.getProperty("username");
		String password = props.getProperty("password");
		
		return DriverManager.getConnection(url, username, password);
	}
}
