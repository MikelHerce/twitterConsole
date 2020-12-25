/**
 * 
 */
package application.command.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class CommandParserRepository {

	private List<CommandParser> parsers;
	private PostCommandParser postCommandParser = new PostCommandParser();
	private FollowCommandParser followCommandParser = new FollowCommandParser();
	private ReadCommandParser readCommandParser = new ReadCommandParser();
	private WallCommandParser wallCommandParser = new WallCommandParser();
	

	public CommandParserRepository() {
		super();
		this.parsers = new ArrayList<CommandParser>();
		this.parsers.add(postCommandParser);
		this.parsers.add(followCommandParser);
		this.parsers.add(readCommandParser);
		this.parsers.add(wallCommandParser);
	}



	public Optional<CommandParser> findParser(String line) {
		return parsers.stream().filter(p->p.isThePattern(line)).findFirst();
	}
}
