package ru.vorobev.lesson_04.patterns.system_patterns.orm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UnitOfWork {
	
	private final Connection connection;
	private List<User> newUsers = new ArrayList<>();
	private List<User> updateUsers = new ArrayList<>();
	private List<User> deleteUsers = new ArrayList<>();
	
	public UnitOfWork(Connection connection) {
		this.connection = connection;
	}
	
	public void registerNew(User user) {
		this.newUsers.add(user);
	}
	
	public void registerUpdate(User user) {
		this.updateUsers.add(user);
	}
	
	public void registerDelete(User user) {
		this.deleteUsers.add(user);
	}
	
	public void commit() {
		insert();
		update();
		delete();
	}
	
	private void insert() {
		PreparedStatement preparedStatement;
		
		for (User user : newUsers) {
			try {
				preparedStatement = connection.prepareStatement("INSERT INTO users (user_name, password) VALUES (?, ?);");
				preparedStatement.setString(1, user.getLogin());
				preparedStatement.setString(2, user.getPassword());
				preparedStatement.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		newUsers.clear();
	}
	
	private void update() {
		PreparedStatement preparedStatement;
		
		for (User user : updateUsers) {
			try {
				preparedStatement = connection.prepareStatement("UPDATE users SET user_name = ?, password = ? WHERE id = ?;");
				preparedStatement.setString(1, user.getLogin());
				preparedStatement.setString(2, user.getPassword());
				preparedStatement.setLong(3, user.getId());
				preparedStatement.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		updateUsers.clear();
	}
	
	private void delete() {
		PreparedStatement preparedStatement;
		
		for (User user : deleteUsers) {
			try {
				preparedStatement = connection.prepareStatement("DELETE FROM users WHERE id = ? ;");
				preparedStatement.setLong(1, user.getId());
				preparedStatement.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		deleteUsers.clear();
	}
}
