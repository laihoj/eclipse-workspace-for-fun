package utils;

import java.util.ArrayList;

import hailo.App;
import hailo.Dimensions;
import hailo.Logging;
import hailo.Point;
import commands.Collision;
import commands.Print;
import commands.Remove;
import gameObjects.Shooter;
import physics.Physics;
import processing.core.PVector;

abstract public class AbstractProjectile extends AbstractGameWidget {
	public float releaseSpeed = -1;
	public Shooter shooter;
	
//	@Deprecated
//    public AbstractProjectile(Shooter shooter) {
//		this(shooter, new Dimensions(5), "pew", "Projectile");
//    }
    
   
    public AbstractProjectile(Shooter shooter, String name, String className) {
    	super(shooter.point(), name, className);
    	this.shooter = shooter;
    	this.setOnEvent("onCollision", new Collision(this));
    	this.physics = new Physics(this)
				.setVelocity(shooter.physics.velocity())
				.setFriction(0.001);
    }
    
//    @Deprecated
//    public AbstractProjectile(Shooter shooter, Dimensions dimensions, String name, String className) {
//    	super(shooter.point(), dimensions, name, className);
//    	this.shooter = shooter;
//    	this.setOnEvent("onCollision", new Collision(this));
//    	this.physics = new Physics(this)
//				.setVelocity(shooter.physics.velocity())
//				.setFriction(0.001);
//    }
    
    public float getReleaseSpeed() {
    	return this.releaseSpeed;
    }
    
    @Override
    public void compute() {
    	super.compute();
    	this.physics.apply();
    }
    
    public PVector velocity() {
    	return this.physics.velocity();
    }
    
    public AbstractProjectile fire(float direction) {
    	new Print(name() + " went pew", Logging.LOGGING);
    	setPoint(new Point(this.point()));
    	PVector vel = new PVector(releaseSpeed,0);
    	vel.rotate(direction);
    	//The shot exits the player from a safe distance, otherwise you shoot your own foot so to say
    	this.point().add(new PVector(this.width() / 2 + this.shooter.width() / 2,0).rotate(direction));
    	vel.add(this.velocity());
    	this.physics.setVelocity(vel);
    	
    	return this;
    }
}