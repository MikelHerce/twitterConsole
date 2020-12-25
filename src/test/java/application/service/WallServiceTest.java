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

import application.service.impl.WallServiceImpl;
import domain.Tweet;
import domain.User;
import domain.tweet.TweetBuilder;
import domain.user.UserBuilder;
import infrastructure.printer.Printer;

public class WallServiceTest {

	
	
	WallService wallService = new WallServiceImpl(Mockito.mock(Printer.class));
	
	@Mock
	List<Tweet> tweetList;
	
	@Mock
	Set<User> followingList;
	
	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
		tweetList = new ArrayList<Tweet>();
		followingList = new HashSet<User>();
	}
	
	@Test
	public void new_user_should_return_empty_tweets() {
		// given
		User noTweetsUser = UserBuilder.aUser().withName("emptyUser").build();
		// when
		List<Tweet> tweetList = wallService.wall(noTweetsUser);
		// then
		assertEquals(0, tweetList.size());
	}
	
	
	@Test
	public void user_with_1_tweet_should_return_1_tweet() {
		// given
		tweetList.add(TweetBuilder.aTweet().withAuthor(null).withMessage("hello").withPublicationDateTime(LocalDateTime.of(2019, 1, 1, 1, 1)).build());
		User oneTweetUser = UserBuilder.aUser().withName(Mockito.anyString()).withTweets(tweetList).build();
		// when
		List<Tweet> tweetList = wallService.wall(oneTweetUser);
		// then
		assertEquals(1, tweetList.size());
	}
	
	@Test
	public void user_with_2_tweet_should_return_2_tweet() {
		// given
		tweetList.add(TweetBuilder.aTweet().withAuthor(null).withMessage("hello").withPublicationDateTime(LocalDateTime.of(2019, 1, 1, 1, 1)).build());
		tweetList.add(TweetBuilder.aTweet().withAuthor(null).withMessage("hello again").withPublicationDateTime(LocalDateTime.of(2019, 1, 1, 1, 1)).build());
		User twoTweetsUser = UserBuilder.aUser().withName(Mockito.anyString()).withTweets(tweetList).build();
		// when
		List<Tweet> tweetList = wallService.wall(twoTweetsUser);
		// then
		assertEquals(2, tweetList.size());
	}
	
	@Test
	public void user_with_1_following_should_return_1_tweet() {
		// given
		
		tweetList.add(TweetBuilder.aTweet().withAuthor(null).withMessage("hello").withPublicationDateTime(LocalDateTime.of(2019, 1, 1, 1, 1)).build());
		followingList.add(UserBuilder.aUser().withTweets(tweetList).build());
		User noTweetUser = UserBuilder.aUser().withName(Mockito.anyString()).withFollowing(followingList).build();
		// when
		List<Tweet> tweetList = wallService.wall(noTweetUser);
		// then
		assertEquals(1, tweetList.size());
	}
	
	@Test
	public void user_with_1_following_should_return_2_tweet() {
		// given
		
		tweetList.add(TweetBuilder.aTweet().withAuthor(null).withMessage("hello").withPublicationDateTime(LocalDateTime.of(2019, 1, 1, 1, 1)).build());
		tweetList.add(TweetBuilder.aTweet().withAuthor(null).withMessage("hello again").withPublicationDateTime(LocalDateTime.of(2019, 1, 1, 1, 1)).build());
		followingList.add(UserBuilder.aUser().withTweets(tweetList).build());
		User noTweetUser = UserBuilder.aUser().withName(Mockito.anyString()).withFollowing(followingList).build();
		// when
		List<Tweet> tweetList = wallService.wall(noTweetUser);
		// then
		assertEquals(2, tweetList.size());
	}


}
