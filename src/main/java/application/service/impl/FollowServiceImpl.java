package application.service.impl;

import application.service.FollowService;
import domain.User;
import infrastructure.repository.UserRepository;

public class FollowServiceImpl implements FollowService{

	private UserRepository userRepository;
	
	
	public FollowServiceImpl(UserRepository repository) {
		super();
		this.userRepository = repository;
	}
	
	@Override
	public User follow(User user, User userToFollow) {
		user.getFollowing().add(userToFollow);
		return userRepository.persist(user);
	}


}
