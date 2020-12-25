package infrastructure.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleCommandReader{
	
	private BufferedReader reader;
	
	public ConsoleCommandReader() {
		reader = new BufferedReader(new InputStreamReader(System.in));
	}

	public String readLine() {
		try {
			return reader.readLine();
		} catch (IOException e) {
			throw new RuntimeException("Failed reading the command", e);
		}
	}
	
}
