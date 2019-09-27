package guns;

import gameObjects.Gun;
import gameObjects.Shooter;
import projectiles.FastBullet;
import projectiles.SlowBullet;

public class MachineGun extends Gun {
	public MachineGun(Shooter player) {
		super(player);
    }
	public Gun reload() {
		for(int i = 0; i < 100; i++) {
			reload(new FastBullet(player),1);	
		}
		return this;
	}
}