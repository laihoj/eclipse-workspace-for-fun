package commands;

import hailo.AbstractCommand;
import hailo.Command;

public class CompoundCommand extends AbstractCommand {
	Command[] commands;
	public CompoundCommand(Command... commands) {
		this.commands = commands;
	}
	public void execute() {
		for(Command command: commands) {
			command.execute();
		}
		super.execute();
	}
}
