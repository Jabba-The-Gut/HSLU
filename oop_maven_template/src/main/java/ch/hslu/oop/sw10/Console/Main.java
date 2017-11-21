package ch.hslu.oop.sw10.Console;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main{
	private static final Logger LOG = LogManager.getLogger(Main.class);

	public static void main(String[] args) {
		Console console = new Console();
		console.main();
	}

}
