package commands;

import hailo.AbstractCommand;
import hailo.App;
import hailo.View;

public class ChangeView extends AbstractCommand {
	public View target;

	public ChangeView(View target) {
		this.target = target;
	}

	public void execute() {
		System.out.println("View changing from " + App.active_view.toString() + " to " + this.target);
		App.activate(target);
	}
}