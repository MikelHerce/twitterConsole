package domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User {
		
	private String name;
	private Set<User> following;
	private List<Tweet> tweets;
	
	
	
	public User(String name) {
		super();
		this.name = name;
	}
	
	public User() {
		super();
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<User> getFollowing() {
		if (null == following) {
			following = new HashSet<>();
		}
		return following;
	}
	public void setFollowing(Set<User> following) {
		this.following = following;
	}
	public List<Tweet> getTweets() {
		if (null == tweets) {
			tweets = new ArrayList<>();
		}
		tweets.sort((tweet1, tweet2) -> tweet2.getPublicationDateTime().compareTo(tweet1.getPublicationDateTime()));
		return tweets;
	}
	public void setTweets(List<Tweet> tweets) {
		this.tweets = tweets;
	}
	
}
