package application.service;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import application.service.impl.ReadServiceImpl;
import domain.Tweet;
import domain.User;
import domain.tweet.TweetBuilder;
import domain.user.UserBuilder;
import infrastructure.printer.Printer;
import infrastructure.repository.LocalRepository;
import infrastructure.repository.UserNotFoundException;
import infrastructure.repository.UserRepository;

public class ReadServiceTest {

	
	
	ReadService readService = new ReadServiceImpl(Mockito.mock(Printer.class));
	
	@Mock
	List<Tweet> tweetList;
	
	@Mock
	Set<User> followingList;
	
	@Mock
	UserRepository userRepository = new LocalRepository();
	
	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
		tweetList = new ArrayList<Tweet>();
		followingList = new HashSet<User>();
	}
	
	@Test
	public void new_user_should_return_empty_tweets() throws UserNotFoundException {
		// given
		User noTweetsUser = UserBuilder.aUser().withName("emptyUser").build();
		// when
		List<Tweet> tweetList = readService.read(noTweetsUser);
		// then
		assertEquals(0, tweetList.size());
	}
	
	
	@Test
	public void user_with_1_tweet_should_return_1_tweet() throws UserNotFoundException {
		// given
		tweetList.add(TweetBuilder.aTweet().withAuthor(null).withMessage("hello").withPublicationDateTime(LocalDateTime.of(2019, 1, 1, 1, 1)).build());
		User oneTweetUser = UserBuilder.aUser().withName("").withTweets(tweetList).build();
		// when
		List<Tweet> tweetList = readService.read(oneTweetUser);
		// then
		assertEquals(1, tweetList.size());
	}
	
	@Test
	public void user_with_2_tweet_should_return_2_tweet() throws UserNotFoundException {
		// given
		tweetList.add(TweetBuilder.aTweet().withAuthor(null).withMessage("hello").withPublicationDateTime(LocalDateTime.of(2019, 1, 1, 1, 1)).build());
		tweetList.add(TweetBuilder.aTweet().withAuthor(null).withMessage("hello again").withPublicationDateTime(LocalDateTime.of(2019, 1, 1, 1, 1)).build());
		User twoTweetsUser = UserBuilder.aUser().withName("").withTweets(tweetList).build();
		// when
		
		List<Tweet> tweetList = readService.read(twoTweetsUser);
		// then
		assertEquals(2, tweetList.size());
	}
	
	@Test
	public void user_with_1_following_should_return_0_tweet() throws UserNotFoundException {
		// given
		
		tweetList.add(TweetBuilder.aTweet().withAuthor(null).withMessage("hello").withPublicationDateTime(LocalDateTime.of(2019, 1, 1, 1, 1)).build());
		followingList.add(UserBuilder.aUser().withTweets(tweetList).build());
		User noTweetUser = UserBuilder.aUser().withName("").withFollowing(followingList).build();
		// when
		List<Tweet> tweetList = readService.read(noTweetUser);
		// then
		assertEquals(0, tweetList.size());
	}
	


}
