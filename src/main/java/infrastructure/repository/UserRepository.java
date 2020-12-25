package infrastructure.repository;

import java.util.List;

import domain.User;

public interface UserRepository {
	
	public User getUser(String userName) throws UserNotFoundException;
	public User persist(User user);
	List<User> getAll();
}
