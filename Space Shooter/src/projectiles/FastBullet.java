package projectiles;

import gameObjects.Player;
import gameObjects.Shooter;
import utils.AbstractProjectile;

public class FastBullet extends AbstractProjectile {
	public FastBullet(Shooter shooter) {
		super(shooter, "pew", "Projectile");
		this.releaseSpeed = 12;
	}
}
