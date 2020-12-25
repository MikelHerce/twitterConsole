package application.command.parser;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import application.command.Command;
import application.command.CommandNotFoundException;
import application.command.PostCommand;
import infrastructure.repository.UserNotFoundException;

public class PostCommandRepositoryTest {

	private CommandParser postCommandParser;
	
	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
		postCommandParser = new PostCommandParser();
	}
	
	@Test
	public void get_PostCommand() throws CommandNotFoundException, UserNotFoundException {
		//given
		String postCommand = "Charlie -> some cool tweet";
		//when
		Command command = postCommandParser.parse(postCommand);
		//then
		assertEquals(PostCommand.class, command.getClass());
	}
	
	@Test (expected = CommandNotFoundException.class)
	public void command_not_found_exception() throws CommandNotFoundException, UserNotFoundException {
		//given
		String wrongPostCommand = "";
		//when
		postCommandParser.parse(wrongPostCommand);
		//then CommandNotFoundExceptionexception
	}
	
	@Test (expected = UserNotFoundException.class)
	public void user_not_found_exception() throws CommandNotFoundException, UserNotFoundException {
		//given
		String wrongPostCommand = "Cha -> tweet";
		//when
		postCommandParser.parse(wrongPostCommand);
	}
	
	@Test
	public void post_pattern_should_match() throws CommandNotFoundException, UserNotFoundException {
		//given
		String postCommand = "Charlie -> another cool tweet!";
		//when
		boolean isPostPattern = postCommandParser.isThePattern(postCommand);
		//then
		assertEquals(true, isPostPattern);
	}
	
	@Test
	public void post_pattern_should_no_match() throws CommandNotFoundException, UserNotFoundException {
		//given
		String wrongPostCommand = "Charlie - t";
		//when
		boolean isPostPattern = postCommandParser.isThePattern(wrongPostCommand);
		//then
		assertEquals(false, isPostPattern);
	}
}
