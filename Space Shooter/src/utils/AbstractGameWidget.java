package utils;

import hailo.App;
import hailo.Command;
import hailo.Dimensions;
import hailo.EventListener;
import hailo.Logging;
import hailo.Point;
import hailo.Widget;
import commands.Print;
import gameObjects.GameView;
import interfaces.Movement;
import physics.Physics;
import processing.core.PVector;

abstract public class AbstractGameWidget extends AbstractGameObserver {
	public GameView parent = null;
	public Physics physics;
	
	public AbstractGameWidget(Point point,String name, String className) {
		super(point, name, className);
		this.physics = new Physics(this).setFriction((float) 0.07);
	}
	
//	@Deprecated
//	public AbstractGameWidget(Point point, Dimensions dimensions, String name, String className) {
//		super(point, dimensions, name, className);
//		this.physics = new Physics(this).setFriction((float) 0.07);
//	}
	@Override
	public void compute() {
		super.compute();
		this.physics.apply();
	}
	public float direction(AbstractGameWidget target) {
		return App.direction(target, this);
	}
	public float direction(Point target) {
		return App.direction(target, this.point());
	}
	public float direction(PVector target) {
		return App.direction(target, this.point().toPVector());
	}
	public void push(PVector force) {
		physics.addForce(force);
	}
	public void go(float direction) {
		this.push(new PVector(Movement.RIGHTWARDS.x, Movement.RIGHTWARDS.y).rotate(direction));
	}
	@Deprecated
	public void setOnOffScreen(Command command) {
		this.setOnEvent("onOffScreen", command);
	}
	@Deprecated
	public void onOffScreen() {
		new Print("Let me figure out what happens when i am off screen", Logging.WARNING);
		if(this.event("onOffScreen") != null) {
			new Print("Aha! I should queue " + this.event("onOffScreen").toString(), Logging.LOGGING);
			this.event("onOffScreen").queue();
		}
	}
	//Cannot collide with objects of the same class
	public boolean collideWith(AbstractGameWidget that) {
		return this.physics.collidingWith(that) && !(that.getClass().isInstance(this));
	}
}
