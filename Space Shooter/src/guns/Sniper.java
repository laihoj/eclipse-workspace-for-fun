package guns;

import gameObjects.Gun;
import gameObjects.Shooter;
import projectiles.FastBullet;
import projectiles.ReallyFastBullet;
import utils.AbstractProjectile;

public class Sniper extends Gun {
	public Sniper(Shooter player) {
		super(player);
    }
	public Gun reload() {
		for(int i = 0; i < 4; i++) {
			reload(new ReallyFastBullet(player),1);	
		}
		return this;
	}
    public AbstractProjectile pressTrigger() {
    	return null;
    }
  }