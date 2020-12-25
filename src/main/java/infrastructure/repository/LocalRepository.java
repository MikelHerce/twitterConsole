package infrastructure.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.User;

public class LocalRepository implements UserRepository{

	
	private static Map<String, User> usersInMemory;


	@Override
	public User getUser(String userName) throws UserNotFoundException {
		User user = getUsersInMemory().get(userName);
		if (null == user) {
			throw new UserNotFoundException();
		}
		return user;
	}
	
	public Map<String, User> getUsersInMemory() {
		if (null == usersInMemory) {
			usersInMemory = new HashMap<>();
			usersInMemory.put("Alice", new User("Alice"));
			usersInMemory.put("Bob", new User("Bob"));
			usersInMemory.put("Charlie", new User("Charlie"));
		}
		return usersInMemory;
	}


	@Override
	public User persist(User user) {
		return this.getUsersInMemory().put(user.getName(), user);
	}
	
	@Override
	public List<User> getAll(){
		return new ArrayList<User>(getUsersInMemory().values());
	}


}
