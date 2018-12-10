package commands;

import hailo.AbstractCommand;
import hailo.App;

public class GoBack extends AbstractCommand {
	public GoBack() {}
	
	public void execute() {
		super.execute();
		App.goBack();
	}
}