package commands;

import hailo.AbstractCommand;
import hailo.App;

public class ToggleNavBar extends AbstractCommand {
	public ToggleNavBar() {}
	public void execute() {
		System.out.println("navbar toggle executed");
		if(!App.navigation_bar.disabled) {
			App.navigation_bar.disable();
		} else {
			App.navigation_bar.enable();
		}
	}
}