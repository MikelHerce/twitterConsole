package application.service;

import java.util.List;

import domain.Tweet;
import domain.User;

public interface WallService {
	
	public List<Tweet> wall(User user);
}
