package gameObjects;

import java.util.ArrayList;

import hailo.App;
import hailo.Point;
import commands.AddGameWidget;
import commands.Remove;
import interfaces.Fire;
import processing.core.PVector;
import utils.AbstractGameWidget;
import utils.AbstractProjectile;

public abstract class Gun implements Fire {
	protected Shooter player;
	ArrayList<AbstractProjectile> magazine;
	float direction;
	public Gun(Shooter player) {
		this.player = player;
		this.direction = 0;
		magazine = new ArrayList<AbstractProjectile>();
	}
	public float bulletVelocity;

	public Gun aim(float direction) {
		this.direction = direction;
		return this;
	}
	public Gun reload() {
		//STUB 
		return this;
	}
	public Gun reload(ArrayList<AbstractProjectile> projectiles) {
		for(AbstractProjectile p: projectiles) {
			magazine.add(p);
		}
		return this;
	}
	
	public Gun reload(AbstractProjectile[] projectiles) {
		for(AbstractProjectile p: projectiles) {
			magazine.add(p);
		}
		return this;
	}
	
	public Gun reload(AbstractProjectile projectile, int quantity) {
		for(int i = 0; i < quantity; i++) {
			magazine.add(projectile);
		}
		return this;
	}
    //Combine velocities of both the shooter and bullet to get total velocity vector
	
	public AbstractProjectile fire() {
		if(magazine.size() > 0) {
			//firing mechanism
			AbstractProjectile shot = magazine.get(0);
			magazine.remove(shot);
			AbstractProjectile blast = shot.fire(this.direction);
			
			//adding the blast to the game
			if(this.player.parent != null) {
				new AddGameWidget(this.player.parent, blast);
				shot.setOnEvent("onOffScreen", new Remove(shot, this.player.parent));
				shot.setOnEvent("onCollision", new Remove(shot, this.player.parent));
			}
			return blast;
		} else {
			System.out.println("Magazine empty");
			return null;
		}
	}
	
	/*
	 * Override these with a do-nothing in the extending gun
	 * For example, a sniper fires only while pulling the trigger
	 * whereas a machine gun fires both while pressing as well as pulling 
	 * */
    public AbstractProjectile pullTrigger() {
    	return fire();
    }
    public AbstractProjectile pressTrigger() {
    	return fire();
    }
  }