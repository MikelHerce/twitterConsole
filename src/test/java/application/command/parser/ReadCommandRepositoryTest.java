package application.command.parser;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import application.command.Command;
import application.command.CommandNotFoundException;
import application.command.ReadCommand;
import infrastructure.repository.UserNotFoundException;

public class ReadCommandRepositoryTest {

	private CommandParser readCommandParser;
	
	
	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
		readCommandParser = new ReadCommandParser();
	}
	
	@Test
	public void get_ReadCommand() throws CommandNotFoundException, UserNotFoundException {
		//given
		String readCommand = "Charlie";
		//when
		Command command = readCommandParser.parse(readCommand);
		//then
		assertEquals(ReadCommand.class, command.getClass());
	}
	
	@Test (expected = UserNotFoundException.class)
	public void user_not_found_exception() throws CommandNotFoundException, UserNotFoundException {
		//given
		String wrongReadCommand = "Cha";
		//when
		readCommandParser.parse(wrongReadCommand);
	}
	
	@Test
	public void read_pattern_should_match() throws CommandNotFoundException, UserNotFoundException {
		//given
		String readCommand = "Charlie";
		//when
		boolean isReadPattern = readCommandParser.isThePattern(readCommand);
		//then
		assertEquals(true, isReadPattern);
	}
	
	@Test
	public void read_pattern_should_no_match() throws CommandNotFoundException, UserNotFoundException {
		//given
		String wrongReadCommand = "Charlie ->";
		//when
		boolean isReadPattern = readCommandParser.isThePattern(wrongReadCommand);
		//then
		assertEquals(false, isReadPattern);
	}
}
