package commands;

import hailo.AbstractCommand;
import hailo.Widget;

public class ToggleWidget extends AbstractCommand {
	Widget widget;
	public ToggleWidget(Widget widget) {}
	public void execute() {
		System.out.println("navbar toggle executed");
		if(!widget.disabled) {
			widget.disable();
		} else {
			widget.enable();
		}
	}
}