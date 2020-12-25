package application.command;

import application.service.WallService;
import domain.User;

public class WallCommand implements Command {

	WallService wallService;
	User user;
	
	public WallCommand(WallService wallService, User user) {
		super();
		this.wallService = wallService;
		this.user = user;
	}

	@Override
	public void execute() {
		wallService.wall(user);
	}

}
