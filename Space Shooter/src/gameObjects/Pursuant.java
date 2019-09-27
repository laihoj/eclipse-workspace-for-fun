package gameObjects;

import hailo.Dimensions;
import hailo.Point;
import commands.Remove;
import intelligences.Pursue;


public class Pursuant extends Shooter {
//	Shooter target = null;
//	@Deprecated
//	public Pursuant(Point point, Dimensions dimensions, Shooter target) {
//		super(point, dimensions, "pursuant 1", "Pursuant");
//		this.setIntelligence(new Pursue(this, target));
//	}
//	public Pursuant(Point point) {
//		super(point, "pursuant 1", "Pursuant");
//		this.add(new Pursue(this, this.target));
//		setOnEvent("onCollision", new Remove(this));
//	}
	
	public Pursuant(Point point, Shooter target) {
		super(point, "pursuant 1", "Pursuant");
		this.add(new Pursue(this, target));
		setOnEvent("onCollision", new Remove(this));
	}
}
	