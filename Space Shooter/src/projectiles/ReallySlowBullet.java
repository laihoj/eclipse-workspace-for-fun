package projectiles;

import gameObjects.Player;
import gameObjects.Shooter;
import utils.AbstractProjectile;


public class ReallySlowBullet extends AbstractProjectile {
	public ReallySlowBullet(Shooter shooter) {
		super(shooter, "pew", "Projectile");
		this.releaseSpeed = 6;
	}
}
