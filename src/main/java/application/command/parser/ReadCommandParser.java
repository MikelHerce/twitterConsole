package application.command.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import application.command.Command;
import application.command.CommandNotFoundException;
import application.command.ReadCommand;
import application.service.ReadService;
import application.service.impl.ReadServiceImpl;
import domain.User;
import infrastructure.printer.ConsolePrinter;
import infrastructure.printer.Printer;
import infrastructure.repository.LocalRepository;
import infrastructure.repository.UserNotFoundException;
import infrastructure.repository.UserRepository;

public class ReadCommandParser implements CommandParser{

	private static final String READ_PATTERN = "^(?<name>[^\\s]*)$";

	private UserRepository usersRepository = new LocalRepository();
	private Printer printer = new ConsolePrinter();
	private ReadService readService = new ReadServiceImpl(printer);

	@Override
	public Command parse(String line) throws CommandNotFoundException, UserNotFoundException {
		Matcher matcher = Pattern.compile(READ_PATTERN).matcher(line);

		if (!matcher.matches()) {
			throw new CommandNotFoundException();
		}

		String userName = matcher.group("name");

		User user = usersRepository.getUser(userName);

		ReadCommand command = new ReadCommand(readService, user);
		return command;
	}

	@Override
	public boolean isThePattern(String line) {
		return line.matches(READ_PATTERN);
	}

}
