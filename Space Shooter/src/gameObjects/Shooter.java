package gameObjects;

import java.util.ArrayList;

import hailo.App;
import hailo.Dimensions;
import hailo.EventListener;
import hailo.Logging;
import hailo.Point;
import hailo.Widget;
import commands.PressTrigger;
import commands.Print;
import commands.PullTrigger;
import guns.MachineGun;
import guns.Pistol;
import guns.Shotgun;
import guns.Sniper;
import utils.AbstractGameWidget;
import utils.AbstractProjectile;
import utils.Intelligence;

abstract public class Shooter extends AbstractGameWidget {
	public ArrayList<Intelligence> intelligences = new ArrayList<Intelligence>();
	public ArrayList<Gun> guns = new ArrayList<Gun>();
	public Gun machineGun;
	public Gun sniperRifle;
	public Gun pistol;
	public Gun shotgun;
	protected Gun gun;
	
	public Shooter(Point point, String name, String className) {
		super(point, name, className);
		machineGun =	new MachineGun(this).reload();
		sniperRifle =	new Sniper(this).reload();
		pistol =		new Pistol(this).reload();
		shotgun =		new Shotgun(this).reload();
		gun =			null;
	}
	
//	@Override
	public void compute() {
		super.compute();
		for(Intelligence intelligence: this.intelligences) {
			if(intelligence != null) {
				intelligence.apply();
			}
		}
	}
	@Deprecated
	public Shooter setIntelligence(Intelligence intelligence) {
		add(intelligence);
		return this;
	}
	public void add(Intelligence intelligence) {
		this.intelligences.add(intelligence);
	}
	public void add(Gun gun) {
		this.guns.add(gun);
	}
	public Shooter setGun(Gun gun) {
		this.gun = gun;
		return this;
	}
	public Shooter setAim(float direction) {
		if(gun() != null) {
			this.gun().aim(direction);			
		}
		return this;
	}
	public ArrayList<Intelligence> intelligences() {
		return this.intelligences;
	}
	public Gun gun() {
		return this.gun;
	}
	public Gun reload() {
		if(this.gun != null) {
			return this.gun().reload();
		} else {
			new Print("Can't reload, no gun equipped", Logging.WARNING);
			return null;
		}
	}
	
	public AbstractProjectile pullTrigger() {
		Gun gun = this.gun();
		if(gun != null) {
			return gun.pullTrigger();
		} else {
			new Print("I have no trigger to pull!", Logging.WARNING);
			return null;
		}
	}
	
	public AbstractProjectile pressTrigger() {
		Gun gun = this.gun();
		if(gun != null) {
			return gun.pressTrigger();
		} else {
			new Print("I have no trigger to press!", Logging.WARNING);
			return null;
		}
	}
	
	@Override
	public void onMouseHover() {
		super.onMouseHover();
		if(gun() != null) {
			gun().aim(direction(new Point(App.mouseX, App.mouseY)));
		}
	}
}