package physics;
import hailo.App;
import processing.core.PVector;
import utils.AbstractGameWidget;

public class Physics {
	AbstractGameWidget widget;
	PVector vel;
	//Friction values are limited to [0, 1], with 0 being no friction and 1 being very high friction
	//Friction's effect is linear.
	float friction;
	public Physics(AbstractGameWidget parent) {
		this.widget = parent;
		setVelocity(new PVector());
		setFriction(0.01);
	}
	public PVector velocity() {
		return this.vel;
	}
	public float friction() {
		return this.friction;
	}
	public void apply() {
		widget.point().add(vel);
		vel.mult(1 - (float) this.friction);
	}
	public Physics setVelocity(PVector vel) {
		this.vel = vel;
		return this;
	}
	public Physics setFriction(float friction) {
		this.friction = App.limit(friction, 0, 1);
		return this;
	}
	public Physics setFriction(double friction) {
		return setFriction((float) friction);
	}
	public Physics addForce(PVector force) {
		this.vel.add(force);
		return this;
	}
	public boolean collidingWith(AbstractGameWidget that) {
		return (float) this.widget.point().dist(that.point())
				< this.widget.dimensions().radius() 
				+ that.dimensions().radius();
//		float distance = (float) this.widget.point.dist(that.point);
//		float thisRad = this.widget.dimensions.getRadius();
//		float thatRad = that.dimensions.getRadius();
//		if(thisRad + thatRad > distance) {return true;}
//		return false;
	}
}
