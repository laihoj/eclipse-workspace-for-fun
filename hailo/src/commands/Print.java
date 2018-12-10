package commands;

import hailo.AbstractCommand;
import hailo.App;
import hailo.Logging;

public class Print extends AbstractCommand {
	String text;
	int loggingLevel;
	public Print(String text, int loggingLevel) {
		this.text = text;
		this.loggingLevel = loggingLevel;
		execute();
	}
	/*
	 * Initialising print without a "priority" means its printed with lowest level
	 * */
	public Print(String text) {
		this(text, Logging.ALL);
	}
	
	/*
	 * Prints the text with the appropriate label 
	 * as long as the app is set to the correct logging level.
	 * The messages that are greater in importance than the threshold are printed
	 * */
	public void execute() {
		if(App.LOGGING_LEVEL <= this.loggingLevel) {
			System.out.println(Logging.LABELS.get(this.loggingLevel) + text);
		}
	}
}
