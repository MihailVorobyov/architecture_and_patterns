package ru.vorobev.lesson_04.patterns.system_patterns.orm;

import java.sql.Connection;
import java.util.Optional;

public class UserRepository {

	private final Connection connection;
	private final UserMapper mapper;
	private UnitOfWork unitOfWork;
	
	public UserRepository(Connection connection) {
		this.connection = connection;
		this.mapper = new UserMapper(connection);
		this.unitOfWork = new UnitOfWork(connection);
	}
	
	public User findById(long id) {
		Optional<User> optionalUser = mapper.findById(id);
		return optionalUser.isEmpty() ? null : optionalUser.get();
	}
	
	public void insert(User user) {
		unitOfWork.registerNew(user);
	}
	
	public void update(User user) {
		unitOfWork.registerUpdate(user);
		mapper.deleteFromCache(user);
	}
	
	public void delete(User user) {
		unitOfWork.registerDelete(user);
		mapper.deleteFromCache(user);
	}
	
	public void beginTransaction() {
		this.unitOfWork = new UnitOfWork(connection);
	}
	
	public void commit() {
		this.unitOfWork.commit();
	}
}
