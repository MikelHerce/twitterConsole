package application.service;

import java.util.List;

import domain.Tweet;
import domain.User;
import infrastructure.repository.UserNotFoundException;

public interface ReadService {
	List<Tweet> read(User user) throws UserNotFoundException;
}
