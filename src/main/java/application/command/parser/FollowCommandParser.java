package application.command.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import application.command.Command;
import application.command.CommandNotFoundException;
import application.command.FollowCommand;
import domain.User;
import infrastructure.repository.LocalRepository;
import infrastructure.repository.UserNotFoundException;
import infrastructure.repository.UserRepository;

public class FollowCommandParser implements CommandParser{

	private static final String FOLLOW_PATTERN = "^(?<name>[^\\s]*) follows (?<userToFollow>[^\\s]*)$";

	private UserRepository usersRepository = new LocalRepository();


	@Override
	public Command parse(String line) throws CommandNotFoundException, UserNotFoundException {
		Matcher matcher = Pattern.compile(FOLLOW_PATTERN).matcher(line);

		if (!matcher.matches()) {
			throw new CommandNotFoundException();
		}

		String userName = matcher.group("name");
		String userToFollowName = matcher.group("userToFollow");

		User user = usersRepository.getUser(userName);
		User userToFollow = usersRepository.getUser(userToFollowName);

		FollowCommand command = new FollowCommand(user, userToFollow);
		return command;
	}


	@Override
	public boolean isThePattern(String line) {
		return line.matches(FOLLOW_PATTERN);
	}

}
