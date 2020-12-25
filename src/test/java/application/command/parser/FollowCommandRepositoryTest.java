package application.command.parser;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import application.command.Command;
import application.command.CommandNotFoundException;
import application.command.FollowCommand;
import infrastructure.repository.UserNotFoundException;
import infrastructure.repository.UserRepository;

public class FollowCommandRepositoryTest {

	private CommandParser followCommandParser;
	@Mock
	private UserRepository userRepository;
	
	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
		followCommandParser = new FollowCommandParser();
	}
	
	@Test
	public void get_FollowCommand() throws CommandNotFoundException, UserNotFoundException {
		//given
		String followCommand = "Charlie follows Bob";
		//when
		Command command = followCommandParser.parse(followCommand);
		//then
		assertEquals(FollowCommand.class, command.getClass());
	}
	
	@Test (expected = CommandNotFoundException.class)
	public void command_not_found_exception() throws CommandNotFoundException, UserNotFoundException {
		//given
		String wrongFollowCommand = "";
		//when
		followCommandParser.parse(wrongFollowCommand);
		//then CommandNotFoundExceptionexception
	}
	
	@Test (expected = UserNotFoundException.class)
	public void user_not_found_exception() throws CommandNotFoundException, UserNotFoundException {
		//given
		String followPostCommand = "Char follows Bob";
		//when
		followCommandParser.parse(followPostCommand);
	}
	
	@Test
	public void follow_pattern_should_match() throws CommandNotFoundException, UserNotFoundException {
		//given
		String followCommand = "Charlie follows Bob";
		//when
		boolean isFollowPattern = followCommandParser.isThePattern(followCommand);
		//then
		assertEquals(true, isFollowPattern);
	}
	
	@Test
	public void follow_pattern_should_no_match() throws CommandNotFoundException, UserNotFoundException {
		//given
		String wrongfollowCommand = "Charlie follow Bob";
		//when
		boolean isFollowPattern = followCommandParser.isThePattern(wrongfollowCommand);
		//then
		assertEquals(false, isFollowPattern);
	}
}
