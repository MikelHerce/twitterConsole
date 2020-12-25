package application.service.impl;

import application.service.PostService;
import domain.Tweet;
import domain.User;
import infrastructure.repository.UserRepository;

public class PostServiceImpl implements PostService{

	
	private UserRepository repository;
	
	
	public PostServiceImpl(UserRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public User post(User user, Tweet tweet) {
		if (null == tweet) {
			return user;
		}
		user.getTweets().add(tweet);
		return repository.persist(user);
	}

}
