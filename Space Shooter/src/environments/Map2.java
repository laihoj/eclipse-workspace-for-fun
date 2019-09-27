package environments;

import hailo.App;
import hailo.Dimensions;
import hailo.Point;
import commands.GameOver;
import commands.PressTrigger;
import commands.PullTrigger;
import commands.Remove;
import commands.Reset;
import displays.GradientRect;
import gameObjects.GameView;
import gameObjects.Player;
import gameObjects.Pursuant;

public class Map2 extends GameView {
	GameView exit;
	public Map2(GameView exit) {
		super(new Point(), "Map 2", "");
		this.exit = exit;
		this.add(new GradientRect(0,180,132,0,180,200));
		Player player = new Player(new Point(App.width/2, App.height/2));
		player.setOnEvent("onCollision", new GameOver(exit));
		this.addGameWidget(player);
		this.setPlayer(player);
		
		this.addGameWidget(new Pursuant(new Point(0, 0), player));
		
		this.addGameWidget(new Pursuant(new Point(App.width, 0), player));
		
		this.addGameWidget(new Pursuant(new Point(0, App.height), player));
		
	}
}