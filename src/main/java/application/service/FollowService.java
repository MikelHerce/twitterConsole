package application.service;

import domain.User;

public interface FollowService{

	User follow(User user, User userToFollow);
}
