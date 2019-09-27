package gameObjects;

import hailo.Logging;
import hailo.Point;
import hailo.View;
import hailo.Widget;
import commands.Print;
import utils.AbstractGameWidget;
import utils.GameEventsListener;

public class GameView extends View {
	public GameEventsListener gameEventsListener;
	Shooter player;// = null;
	public GameView(Point point, String name, String className) {
		super(point, name, className);
		gameEventsListener = new GameEventsListener();
		gameEventsListener.add(this);
		this.add(gameEventsListener);
		this.player = null;
	}
	public GameView setPlayer(Shooter player) {
		this.player = player;
		return this;
	}
	public Shooter player() {
		return this.player;
	}
	public void addGameWidget(AbstractGameWidget child) {
		if(child != null) {
			this.add(child);
			new Print(child.name() + " added via GameView", Logging.LOGGING);
			this.gameEventsListener.addGameWidget(child);
			child.parent = this;
		}
	}

	public void removeGameWidget(AbstractGameWidget child) {
		this.gameEventsListener.removeGameWidget(child);
	}
	
	@Override
	public void compute() {
		super.compute();
		new Print("I, " + name() +", have the following children: ", Logging.LOGGING);
		for(Widget w: gameEventsListener.gameObservers) {
			new Print(w.name(), Logging.LOGGING);
		}
		new Print("They are so many in numbers: " + gameEventsListener.gameObservers.size(), Logging.LOGGING);
	}
}
