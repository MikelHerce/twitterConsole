package application.command.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import application.command.Command;
import application.command.CommandNotFoundException;
import application.command.WallCommand;
import application.service.WallService;
import application.service.impl.WallServiceImpl;
import domain.User;
import infrastructure.printer.ConsolePrinter;
import infrastructure.printer.Printer;
import infrastructure.repository.LocalRepository;
import infrastructure.repository.UserNotFoundException;
import infrastructure.repository.UserRepository;

public class WallCommandParser implements CommandParser{

	private static final String WALL_PATTERN = "^(?<name>[^\\s]*) wall$";

	private UserRepository usersRepository = new LocalRepository();
	private Printer printer = new ConsolePrinter();
	private WallService wallService = new WallServiceImpl(printer);

	@Override
	public Command parse(String line) throws CommandNotFoundException, UserNotFoundException {
		Matcher matcher = Pattern.compile(WALL_PATTERN).matcher(line);

		if (!matcher.matches()) {
			throw new CommandNotFoundException();
		}

		String userName = matcher.group("name");

		User user = usersRepository.getUser(userName);

		WallCommand command = new WallCommand(wallService, user);
		return command;
	}

	@Override
	public boolean isThePattern(String line) {
		return line.matches(WALL_PATTERN);
	}

}
