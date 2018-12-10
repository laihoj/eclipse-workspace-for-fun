package hailo;

import commands.Print;

abstract public class AbstractCommand implements Command {
	public boolean executed = false;
	public void queue() {
		new Print("Command queued", Logging.LOGGING);
		App.queue(this);
	}
	public boolean isExecuted() {
		return executed;
	}
	/*
	 * Try to call this as much from sub methods
	 * */
	public void execute() {
		new Print("Command Executed", Logging.LOGGING);
		this.executed = true;
	}
	
	/*
	 * Try to call this as much from sub methods
	 * */
	public void undo() {
		this.executed = false;
	}
}