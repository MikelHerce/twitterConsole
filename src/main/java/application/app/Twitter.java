package application.app;
import java.util.Optional;
import java.util.Scanner;

import application.command.Command;
import application.command.CommandNotFoundException;
import application.command.parser.CommandParser;
import application.command.parser.CommandParserRepository;
import infrastructure.printer.ConsolePrinter;
import infrastructure.printer.Printer;
import infrastructure.repository.UserNotFoundException;

public class Twitter {

	private CommandParserRepository parserRepository = new CommandParserRepository();
	
	private Printer printer = new ConsolePrinter();
	private Scanner scanner = new Scanner(System.in);
	
	public void start() {

		printer.printLine("Welcome to twitter-console, developed by Mikel Herce");
		String consoleCommand;
		do {
			consoleCommand = scanner.nextLine();
			try {
				executeCommand(consoleCommand);					
			} catch (CommandNotFoundException e) {
				printer.printLine("Command not found");
			} catch (UserNotFoundException e) {
				printer.printLine("User not found");
			}
		} while (true);	
		
	}
	
	private void executeCommand(String consoleCommand) throws CommandNotFoundException, UserNotFoundException {
		Optional<CommandParser> parser = parserRepository.findParser(consoleCommand);
		if (parser.isPresent()) {
			Command command = parser.get().parse(consoleCommand);
			command.execute();
		} else {
			printer.printLine("Unknown command: " + consoleCommand);
		}
		
	}	
}
