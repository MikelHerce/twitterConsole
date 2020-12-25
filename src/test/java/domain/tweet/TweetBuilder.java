package domain.tweet;

import java.time.LocalDateTime;

import domain.Tweet;
import domain.User;

public class TweetBuilder{
	
	private User author;
	private LocalDateTime publicationDateTime;
	private String message;
    
    public static TweetBuilder aTweet() {
    	return new TweetBuilder();
    }
    
    public Tweet build() {
    	Tweet tweet = new Tweet();
    	tweet.setAuthor(author);
    	tweet.setPublicationDateTime(publicationDateTime);
    	tweet.setMessage(message);
		return tweet;
    }
    
    public TweetBuilder withAuthor(User author) {
    	this.author = author;
    	return this;
    }
    
    public TweetBuilder withPublicationDateTime(LocalDateTime publicationDateTime) {
    	this.publicationDateTime = publicationDateTime;
    	return this;
    }
    public TweetBuilder withMessage(String message) {
    	this.message = message;
    	return this;
    }
    

}
