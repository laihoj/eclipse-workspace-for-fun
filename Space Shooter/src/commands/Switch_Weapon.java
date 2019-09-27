package commands;

import hailo.AbstractCommand;
import gameObjects.Gun;
import gameObjects.Shooter;

public class Switch_Weapon extends AbstractCommand {
	Shooter shooter;
	gameObjects.Gun gun;
	
	
	public Switch_Weapon(Shooter shooter, Gun gun) {
		super();
		this.shooter = shooter;
		this.gun = gun;
	}
	
	
	public void execute() {
		this.shooter.setGun(gun);
	}
	
	
}