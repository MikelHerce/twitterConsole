package application.command.parser;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import application.command.Command;
import application.command.CommandNotFoundException;
import application.command.WallCommand;
import infrastructure.repository.UserNotFoundException;

public class WallCommandRepositoryTest {

	private CommandParser wallCommandParser;
	
	
	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
		wallCommandParser = new WallCommandParser();
	}
	
	@Test
	public void get_WallCommand() throws CommandNotFoundException, UserNotFoundException {
		//given
		String wallCommand = "Charlie wall";
		//when
		Command command = wallCommandParser.parse(wallCommand);
		//then
		assertEquals(WallCommand.class, command.getClass());
	}
	
	@Test (expected = CommandNotFoundException.class)
	public void command_not_found_exception() throws CommandNotFoundException, UserNotFoundException {
		//given
		String wrongWallCommand = "";
		//when
		wallCommandParser.parse(wrongWallCommand);
		//then CommandNotFoundExceptionexception
	}
	
	@Test (expected = UserNotFoundException.class)
	public void user_not_found_exception() throws CommandNotFoundException, UserNotFoundException {
		//given
		String wrongWallCommand = "Cha wall";
		//when
		wallCommandParser.parse(wrongWallCommand);
	}
	
	@Test
	public void wall_pattern_should_match() throws CommandNotFoundException, UserNotFoundException {
		//given
		String wallCommand = "Charlie wall";
		//when
		boolean isWallPattern = wallCommandParser.isThePattern(wallCommand);
		//then
		assertEquals(true, isWallPattern);
	}
	
	@Test
	public void wall_pattern_should_no_match() throws CommandNotFoundException, UserNotFoundException {
		//given
		String wrongWallCommand = "Charlie walll";
		//when
		boolean isWallPattern = wallCommandParser.isThePattern(wrongWallCommand);
		//then
		assertEquals(false, isWallPattern);
	}
}
