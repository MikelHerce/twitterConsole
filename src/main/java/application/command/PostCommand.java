package application.command;

import application.service.PostService;
import domain.Tweet;
import domain.User;

public class PostCommand implements Command {

	
	private PostService postService;
	private User user;
	private Tweet tweet;

	public PostCommand(PostService postService, User user, Tweet tweet) {
		super();
		this.postService = postService;
		this.user = user;
		this.tweet = tweet;
	}


	@Override
	public void execute() {
		postService.post(user, tweet);
	}



}
