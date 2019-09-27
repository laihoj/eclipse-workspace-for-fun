package commands;

import hailo.AbstractCommand;
import hailo.Logging;
import utils.AbstractGameWidget;

public class Collision extends AbstractCommand {
	AbstractGameWidget self;
	AbstractGameWidget with = null;
	public Collision(AbstractGameWidget self) {
		this.self = self;
	}
	public void with(AbstractGameWidget with) {
		this.with = with;
	}
	public void execute() {
		new Print("Impact!", Logging.WARNING);
	}
}
