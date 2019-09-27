package projectiles;

import gameObjects.Player;
import gameObjects.Shooter;
import utils.AbstractProjectile;


public class ReallyFastBullet extends AbstractProjectile {
	public ReallyFastBullet(Shooter shooter) {
		super(shooter, "pew", "Projectile");
		this.releaseSpeed = 45;
	}
}
