package application.command.parser;

import application.command.Command;
import application.command.CommandNotFoundException;
import infrastructure.repository.UserNotFoundException;


public interface CommandParser {
	public Command parse(String line) throws CommandNotFoundException, UserNotFoundException;
	
	public boolean isThePattern(String line);
}
