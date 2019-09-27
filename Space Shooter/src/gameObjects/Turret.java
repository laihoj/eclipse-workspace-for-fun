package gameObjects;

import hailo.Dimensions;
import hailo.Point;
import commands.Remove;
import guns.Cannon;
import intelligences.ShootAt;

public class Turret extends Shooter {
	public Turret(Point point, Shooter target) {
		super(point, "turret 1", "Turret");
		add(new ShootAt(this, target));
		setGun(new Cannon(this).reload());
		setOnEvent("onCollision", new Remove(this));
	}
	
//	@Deprecated
//	public Turret(Point point, Dimensions dimensions, Player target) {
//		super(point, dimensions, "turret 1", "Turret");
//		add(new ShootAt(this, target));
//		setGun(new Cannon(this).reload());
//		
//	}
}
