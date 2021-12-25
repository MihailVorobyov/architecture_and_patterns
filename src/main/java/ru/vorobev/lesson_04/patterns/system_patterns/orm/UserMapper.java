package ru.vorobev.lesson_04.patterns.system_patterns.orm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UserMapper {
	
	private final Connection connection;
	private final PreparedStatement selectUser;
	private final Map<Long, User> identityMap = new HashMap<>();
	
	public UserMapper(Connection connection) {
		this.connection = connection;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("USE patterns;");
			this.selectUser = connection.prepareStatement("SELECT id, user_name, password FROM users WHERE id = ?;");
		} catch (SQLException e) {
			throw new IllegalStateException(e);
		}
	}
	
	public Optional<User> findById(long id) {
		User user = identityMap.get(id);
		if (user != null) {
			return Optional.of(user);
		}
		try {
			selectUser.setLong(1, id);
			ResultSet rs = selectUser.executeQuery();
			if (rs.next()) {
				user = new User(rs.getInt(1), rs.getString(2), rs.getString(3));
				identityMap.put(id, user);
				return Optional.of(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Optional.empty();
	}
	
	void deleteFromCache(User user) {
		identityMap.remove(user.getId());
	}
}
