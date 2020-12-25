package domain;

import java.time.LocalDateTime;

import infrastructure.helper.DateHelper;
import infrastructure.helper.TimeAgoDateHelper;

public class Tweet {
	private DateHelper dateHelper = new TimeAgoDateHelper();
	
	private User author;
	private LocalDateTime publicationDateTime;
	private String message;
	
	
	public Tweet(User author, LocalDateTime publicationDateTime, String message) {
		super();
		this.author = author;
		this.publicationDateTime = publicationDateTime;
		this.message = message;
	}
	
	public Tweet() {
		super();
	}

	public User getAuthor() {
		if (author == null) {
			author = new User();
		}
		return author;
	}
	public void setAuthor(User author) {
		this.author = author;
	}
	public LocalDateTime getPublicationDateTime() {
		return publicationDateTime;
	}
	public void setPublicationDateTime(LocalDateTime publicationDateTime) {
		this.publicationDateTime = publicationDateTime;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return this.getMessage() + " (" + dateHelper.timeAgo(this.getPublicationDateTime()) + ")";
	}
	
	
	
}
