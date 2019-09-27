package guns;

import gameObjects.Gun;
import gameObjects.Shooter;
import projectiles.FastBullet;
import projectiles.SlowBullet;
import utils.AbstractProjectile;

public class Pistol extends Gun {
	public Pistol(Shooter player) {
		super(player);
		reload();
    }
	public Gun reload() {
		for(int i = 0; i < 12; i++) {
			reload(new SlowBullet(player),1);	
		}
		return this;
	}
	/*
	 * Keeping the trigger pressed does nothing with a pistol
	 * */
	public AbstractProjectile pressTrigger() {
		return null;
	}
}