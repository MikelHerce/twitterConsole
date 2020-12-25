package application.command.parser;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Test;

public class CommandParserRepositoryTest {

	private CommandParserRepository commandParserRepository = new CommandParserRepository();
	
	@Test
	public void should_return_FollowCommand() {
		// given
		String line = "user follows tweet";
		// when
		Optional<CommandParser> command = commandParserRepository.findParser(line);
		// then
		assertEquals(FollowCommandParser.class, command.get().getClass());
	}
	@Test
	public void should_return_PostCommand() {
		// given
		String line = "user -> tweet";
		// when
		Optional<CommandParser> command = commandParserRepository.findParser(line);
		// then
		assertEquals(PostCommandParser.class, command.get().getClass());
	}
	
	@Test
	public void should_return_ReadCommand() {
		// given
		String line = "user";
		// when
		Optional<CommandParser> command = commandParserRepository.findParser(line);
		// then
		assertEquals(ReadCommandParser.class, command.get().getClass());
	}
	
	@Test
	public void should_return_WallCommand() {
		// given
		String line = "user wall";
		// when
		Optional<CommandParser> command = commandParserRepository.findParser(line);
		// then
		assertEquals(WallCommandParser.class, command.get().getClass());
	}
	
	@Test
	public void should_return_empty() {
		// given
		String line = "some some";
		// when
		Optional<CommandParser> command = commandParserRepository.findParser(line);
		// then
		assertEquals(Optional.empty(), command);
	}
	
}
