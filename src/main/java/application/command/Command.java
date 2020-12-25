package application.command;

import infrastructure.repository.UserNotFoundException;

public interface Command {

	void execute() throws UserNotFoundException;
	
	
}
