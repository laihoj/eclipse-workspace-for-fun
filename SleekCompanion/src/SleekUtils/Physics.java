package SleekUtils;
import hailo.App;
import hailo.Point;
import hailo.Widget;
import processing.core.PVector;

public class Physics {
	Widget widget;
	PVector vel;
	//Friction values are limited to [0, 1], with 0 being no friction and 1 being very high friction
	//Friction's effect is linear.
	float friction;
	public Physics(Widget parent) {
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
		PVector point = widget.point().toPVector();
		widget.point().add(vel);
		if(PVector.dist(point, widget.point().toPVector()) != 0) {
			vel.mult(1 - (float) this.friction);
			App.redraw();
		}
		
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
	public boolean collidingWith(Widget that) {
		return (float) this.widget.point().dist(that.point())
				< this.widget.dimensions().radius() 
				+ that.dimensions().radius();
	}
}
