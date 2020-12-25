package domain.user;

import java.util.List;
import java.util.Set;

import domain.Tweet;
import domain.User;

public class UserBuilder{
	
	private String name;
	private Set<User> following;
	private List<Tweet> tweets;
    
    public static UserBuilder aUser() {
    	return new UserBuilder();
    }
    
    public User build() {
    	User user = new User();
    	user.setName(name);
    	user.setFollowing(following);
    	user.setTweets(tweets);
		return user;
    }
    
    public UserBuilder withName(String name) {
    	this.name = name;
    	return this;
    }
    public UserBuilder withFollowing(Set<User> following) {
    	this.following = following;
    	return this;
    }
    public UserBuilder withTweets(List<Tweet> tweet) {
    	this.tweets = tweet;
    	return this;
    }

}
