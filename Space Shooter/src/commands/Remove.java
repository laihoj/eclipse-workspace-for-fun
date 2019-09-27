package commands;

import hailo.AbstractCommand;
import hailo.Logging;
import hailo.Widget;
import gameObjects.GameView;
import utils.AbstractGameWidget;

public class Remove extends AbstractCommand {
	AbstractGameWidget widget;
	GameView parent;
	public Remove(AbstractGameWidget widget) {
		this.widget = widget;
//		this.parent = parent;
	}
	@Deprecated
	public Remove(AbstractGameWidget widget, GameView parent) {
		this.widget = widget;
		this.parent = parent;
	}
	public void execute() {
		super.execute();
		widget.parent.removeGameWidget(widget);
		widget.parent.remove(widget);
		new Print("Remove executed", Logging.DEBUG);
	}
}
