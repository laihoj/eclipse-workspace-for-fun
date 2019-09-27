package projectiles;

import hailo.Dimensions;
import gameObjects.Shooter;
import utils.AbstractProjectile;

public class CannonBall extends AbstractProjectile {
	public CannonBall(Shooter shooter) {
		super(shooter, "PEW", "CannonBall");
//		super(shooter, new Dimensions(20), "boom", "Projectile");
		this.releaseSpeed = 10;
	}
}
