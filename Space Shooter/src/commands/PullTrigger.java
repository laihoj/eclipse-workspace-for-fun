package commands;

import hailo.AbstractCommand;
import gameObjects.GameView;
import gameObjects.Gun;
import gameObjects.Shooter;
import utils.AbstractProjectile;

public class PullTrigger extends AbstractCommand {
	Shooter shooter;
	GameView map;
	@Deprecated
	public PullTrigger(Shooter shooter, GameView map){
		this.shooter = shooter;
		this.map = map;
	}
	public PullTrigger(Shooter shooter){
		this.shooter = shooter;
	}
	public void execute() {
		shooter.pullTrigger();
	}
}