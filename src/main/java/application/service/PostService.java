package application.service;

import domain.Tweet;
import domain.User;

public interface PostService {

	User post(User user, Tweet tweet);
}
