package commands;

import hailo.AbstractCommand;
import gameObjects.GameView;
import gameObjects.Shooter;
import utils.AbstractProjectile;

public class PressTrigger extends AbstractCommand {
	Shooter shooter;
	GameView map;
	//TODO: remove map from constructor, not necessary since gun takes care of the adding to the map
	@Deprecated
	public PressTrigger(Shooter shooter, GameView map){
		this.shooter = shooter;
		this.map = map;
	}
	public PressTrigger(Shooter shooter){
		this.shooter = shooter;
	}
	public void execute() {
		shooter.pressTrigger();
	}
}