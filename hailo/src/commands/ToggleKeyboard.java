package commands;

import hailo.AbstractCommand;
import hailo.App;

public class ToggleKeyboard extends AbstractCommand {
	public ToggleKeyboard() {}
	public void execute() {
		System.out.println("keyboard toggle executed");
		App.keyboard.toggle();
	}
}