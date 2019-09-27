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
import gameObjects.Ship1;
import gameObjects.Shooter;
import gameObjects.Turret;

public class Map1 extends GameView {
	GameView exit;
	public Map1(GameView exit) {
		super(new Point(), "Map 1", "");
		this.exit = exit;
		this.add(new GradientRect(0,132,180,0,200,180));
		
		Player player = new Player(new Point(App.width/2, App.height/2));
		player.setOnEvent("onCollision", new GameOver(exit));
		this.addGameWidget(player);
		this.setPlayer(player);
		
		/*Attempt at having a special player object which has a shooter variable, 
		 * rather than extending shooter*/
//		Shooter player = new Ship1(new Point(App.width/2, App.height/2));
//		player.setOnEvent("onCollision", new GameOver(exit));
//		this.addGameWidget(player);
//		this.setPlayer(player);
		
		this.addGameWidget(new Turret(new Point(50, 50), player));
	}
}
