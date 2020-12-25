package application.service.impl;

import java.util.ArrayList;
import java.util.List;

import application.service.WallService;
import domain.Tweet;
import domain.User;
import infrastructure.printer.Printer;

public class WallServiceImpl implements WallService{

	Printer printRepository;
	
	
	
	public WallServiceImpl(Printer printer) {
		super();
		this.printRepository = printer;
	}



	@Override
	public List<Tweet> wall(User user) {
		
		List<Tweet> cachedTweets = new ArrayList<Tweet>(); 
		cachedTweets.addAll(user.getTweets());
		for (User followingUser : user.getFollowing()) {
			cachedTweets.addAll(followingUser.getTweets());
		}
		cachedTweets.sort((tweet1, tweet2) -> tweet2.getPublicationDateTime().compareTo(tweet1.getPublicationDateTime()));
		for (Tweet tweet : cachedTweets) {
			printRepository.printLine(formatWall(tweet));
		}
		return cachedTweets;
	}
	
	private String formatWall(Tweet tweet) {
		return tweet.getAuthor().getName() + " - " + tweet.toString();
	}

}
