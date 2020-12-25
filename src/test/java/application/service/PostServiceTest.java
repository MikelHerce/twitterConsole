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

import application.service.impl.PostServiceImpl;
import domain.Tweet;
import domain.User;
import domain.tweet.TweetBuilder;
import domain.user.UserBuilder;
import infrastructure.repository.UserRepository;

public class PostServiceTest {

	
	
	PostService postService = new PostServiceImpl(Mockito.mock(UserRepository.class));
	
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
	public void should_return_empty_tweets() {
		//given
		User aNewUser = UserBuilder.aUser().withName("new").build();
		//when
		postService.post(aNewUser, null);
		//then
		assertEquals(0, aNewUser.getTweets().size());
	}
	@Test
	public void postin_first_tweet_should_return_1_tweet() {
		//given
		User aNewUser = UserBuilder.aUser().withName("new").build();
		Tweet tweet = TweetBuilder.aTweet().withMessage("any").withAuthor(aNewUser).build();
		//when
		postService.post(aNewUser, tweet);
		//then
		assertEquals(1, aNewUser.getTweets().size());
	}
	@Test
	public void postin_second_tweet_should_return_2_tweet() {
		//given
		User aNewUser = UserBuilder.aUser().withName("new").withTweets(tweetList).build();
		Tweet tweet = TweetBuilder.aTweet().withMessage("any").withAuthor(aNewUser).withPublicationDateTime(LocalDateTime.now()).build();
		tweetList.add(TweetBuilder.aTweet().withAuthor(aNewUser).withMessage("previousTweet").withPublicationDateTime(LocalDateTime.now()).build());
		//when
		postService.post(aNewUser, tweet);
		//then
		assertEquals(2, aNewUser.getTweets().size());
	}
	
	



}
