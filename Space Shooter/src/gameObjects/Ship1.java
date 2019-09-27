package gameObjects;

import hailo.Point;
import commands.Remove;
import guns.Pistol;
import intelligences.Pursue;
import intelligences.ShootAt;

public class Ship1 extends Shooter {
	public Ship1(Point point) {
		super(point, "player 1", "Ship1");
		this.add(new intelligences.Player(this));
		this.setGun(new Pistol(this));
		setOnEvent("onCollision", new Remove(this));
	}
}
