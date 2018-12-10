package commands;

import hailo.AbstractCommand;

public class DoNothing extends AbstractCommand {
	public DoNothing(){}
	public void execute() {
		System.out.println("Did Nothing, and Nothing happened!");
	}
}