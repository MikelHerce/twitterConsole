package application.command;

import application.service.ReadService;
import domain.User;
import infrastructure.repository.UserNotFoundException;

public class ReadCommand implements Command {

	private ReadService readService;
	private User user;
	
	
	public ReadCommand(ReadService readService, User user) {
		super();
		this.readService = readService;
		this.user = user;
	}


	@Override
	public void execute() throws UserNotFoundException {
		readService.read(user);
		
	}

}
