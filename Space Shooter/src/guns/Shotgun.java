package guns;

import gameObjects.Gun;
import gameObjects.Shooter;
import projectiles.CompoundProjectile;
import projectiles.FastBullet;
import projectiles.ReallySlowBullet;
import utils.AbstractProjectile;


public class Shotgun extends Gun {
	public Shotgun(Shooter player) {
		super(player);
    }
	public Gun reload() {
		for(int i = 0; i < 16; i++) {
			reload(new ReallySlowBullet(player),1);	
		}
		return this;
	}
    public AbstractProjectile pullTrigger() {
    	CompoundProjectile blast = new CompoundProjectile(this.player);
    	for(int i = 0; i < 8; i++) {
    		AbstractProjectile shot = fire();
    		if(shot != null) {
    			blast.add(shot);
    			shot.velocity().rotate((float) ((Math.random() - 0.5) * 0.6));
    		}
    	}
    	return blast;
    }

    public AbstractProjectile pressTrigger() {
    	return null;
    }
}