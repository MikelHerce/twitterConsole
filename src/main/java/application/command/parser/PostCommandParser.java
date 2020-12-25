package application.command.parser;

import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import application.command.Command;
import application.command.CommandNotFoundException;
import application.command.PostCommand;
import application.service.PostService;
import application.service.impl.PostServiceImpl;
import domain.Tweet;
import domain.User;
import infrastructure.repository.LocalRepository;
import infrastructure.repository.UserNotFoundException;
import infrastructure.repository.UserRepository;

public class PostCommandParser implements CommandParser{

	private static final String POST_PATTERN = "^(?<name>[^\\s]*) -> (?<message>.*)$";

	private UserRepository usersRepository = new LocalRepository();
	private PostService postService = new PostServiceImpl(usersRepository);

	@Override
	public Command parse(String line) throws CommandNotFoundException, UserNotFoundException {
		Matcher matcher = Pattern.compile(POST_PATTERN).matcher(line);

		if (!matcher.matches()) {
			throw new CommandNotFoundException();
		}

		String userName = matcher.group("name");
		String message = matcher.group("message");

		User user = usersRepository.getUser(userName);
		Tweet tweet = new Tweet(user, LocalDateTime.now(), message);

		PostCommand command = new PostCommand(postService, user, tweet);
		return command;
	}

	@Override
	public boolean isThePattern(String line) {
		return line.matches(POST_PATTERN);
	}

}
