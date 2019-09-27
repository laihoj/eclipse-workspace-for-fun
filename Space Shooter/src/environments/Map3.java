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
import gameObjects.ShootyFollowy;

public class Map3 extends GameView {
	GameView exit;
	public Map3(GameView exit) {
		super(new Point(), "Map 3", "");
		this.exit = exit;
		this.add(new GradientRect(255,255,255,150,180,200));
		
		Player player = new Player(new Point(App.width/2, App.height/2));
		player.setOnEvent("onCollision", new GameOver(exit));
		this.addGameWidget(player);
		this.setPlayer(player);
		
		this.addGameWidget(new ShootyFollowy(new Point(50, 50), player));
	}
}