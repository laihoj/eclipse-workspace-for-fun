package guns;

import gameObjects.Gun;
import gameObjects.Shooter;
import projectiles.CannonBall;

public class Cannon extends Gun {
	public Cannon(Shooter player) {
		super(player);
    }
	public Gun reload() {
		for(int i = 0; i < 100; i++) {
			reload(new CannonBall(player),1);	
		}
		return this;
	}
}