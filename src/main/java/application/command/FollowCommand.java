package application.command;

import application.service.FollowService;
import application.service.impl.FollowServiceImpl;
import domain.User;
import infrastructure.repository.LocalRepository;

public class FollowCommand implements Command{

	private FollowService followService = new FollowServiceImpl(new LocalRepository());
	
	private User user;
	private User userToFollow;

	public FollowCommand(User user, User userToFollow) {
		this.user = user;
		this.userToFollow = userToFollow;
	}

	@Override
	public void execute() {
		followService.follow(user, userToFollow);
	}

}
