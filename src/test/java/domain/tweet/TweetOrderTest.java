package domain.tweet;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import domain.Tweet;
import domain.User;
import domain.user.UserBuilder;
import infrastructure.repository.UserNotFoundException;

public class TweetOrderTest {
	
	@Mock
	List<Tweet> tweetList;
	
	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
		tweetList = new ArrayList<Tweet>();
	}
	
	@Test
	public void should_return_the_tweet() throws UserNotFoundException {
		// given
		tweetList.add(TweetBuilder.aTweet().withMessage("old").withPublicationDateTime(LocalDateTime.MIN).build());		
		User userWithTwoTweets = UserBuilder.aUser().withTweets(tweetList).build();
		// when
		Tweet firstTweet = userWithTwoTweets.getTweets().get(0);
		// then
		assertEquals(LocalDateTime.MIN, firstTweet.getPublicationDateTime());
	}
	
	@Test
	public void should_return_newest_tweet_first() throws UserNotFoundException {
		// given
		tweetList.add(TweetBuilder.aTweet().withMessage("old").withPublicationDateTime(LocalDateTime.MIN).build());		
		tweetList.add(TweetBuilder.aTweet().withMessage("new").withPublicationDateTime(LocalDateTime.MAX).build());
		User userWithTwoTweets = UserBuilder.aUser().withTweets(tweetList).build();
		// when
		Tweet firstTweet = userWithTwoTweets.getTweets().get(0);
		// then
		assertEquals(LocalDateTime.MAX, firstTweet.getPublicationDateTime());
	}
	
	@Test
	public void should_return_newest_tweet_first_and_oldest_last() throws UserNotFoundException {
		// given
		tweetList.add(TweetBuilder.aTweet().withMessage("old").withPublicationDateTime(LocalDateTime.MIN).build());		
		tweetList.add(TweetBuilder.aTweet().withMessage("mid").withPublicationDateTime(LocalDateTime.now()).build());		
		tweetList.add(TweetBuilder.aTweet().withMessage("new").withPublicationDateTime(LocalDateTime.MAX).build());
		User userWithThreeTweets = UserBuilder.aUser().withTweets(tweetList).build();
		// when
		Tweet firstTweet = userWithThreeTweets.getTweets().get(0);
		Tweet lastTweet = userWithThreeTweets.getTweets().get(2);
		// then
		assertEquals(LocalDateTime.MAX, firstTweet.getPublicationDateTime());
		assertEquals(LocalDateTime.MIN, lastTweet.getPublicationDateTime());
	}
}
