package application.service.impl;

import java.util.List;

import application.service.ReadService;
import domain.Tweet;
import domain.User;
import infrastructure.printer.Printer;
import infrastructure.repository.UserNotFoundException;

public class ReadServiceImpl implements ReadService{

	private Printer printRepository;
	
	
	public ReadServiceImpl(Printer printRepository) {
		super();
		this.printRepository = printRepository;
	}


	@Override
	public List<Tweet> read(User user) throws UserNotFoundException {
		List<Tweet> tweets = user.getTweets();
		for (Tweet tweet : tweets) {
			printRepository.printLine(formatRead(tweet));
		}
		return tweets;
	}
	
	private String formatRead(Tweet tweet) {
		return tweet.toString();
	}

}
