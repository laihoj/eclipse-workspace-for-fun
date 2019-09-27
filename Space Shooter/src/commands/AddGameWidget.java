package commands;

import hailo.AbstractCommand;
import hailo.App;
import gameObjects.GameView;
import utils.AbstractGameWidget;

public class AddGameWidget extends AbstractCommand {
	GameView view; 
	AbstractGameWidget child;
	public AddGameWidget(GameView view, AbstractGameWidget child) {
		this.view = view;
		this.child = child;
		App.queue(this);
	}
	public void execute() {
		this.view.addGameWidget(child);
	}
}
