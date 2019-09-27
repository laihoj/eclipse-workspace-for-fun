package projectiles;

import hailo.Point;
import gameObjects.Player;
import gameObjects.Shooter;
import processing.core.PVector;
import utils.AbstractProjectile;

public class SlowBullet extends AbstractProjectile {
	public SlowBullet(Shooter shooter) {
		super(shooter, "pew", "Projectile");
		this.releaseSpeed = 8;
	}
}
