package infrastructure.printer;

public class ConsolePrinter implements Printer{

	@Override
	public String printLine(String message) {
		System.out.println(message);
		return message;
	}

}
