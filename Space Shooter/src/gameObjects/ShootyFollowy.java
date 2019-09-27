package gameObjects;

import hailo.Dimensions;
import hailo.Point;
import commands.Remove;
import guns.Pistol;
import intelligences.Pursue;
import intelligences.ShootAt;

//public class ShootyFollowy {
//
//}
public class ShootyFollowy extends Shooter {
	public ShootyFollowy(Point point, Shooter target) {
		super(point, "shootyfollower 1", "ShootyFollowy");
		this.add(new Pursue(this, target));
		this.add(new ShootAt(this, target));
		this.setGun(new Pistol(this));
		setOnEvent("onCollision", new Remove(this));
	}
}
	