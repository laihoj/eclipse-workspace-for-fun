package gameObjects;

import hailo.Dimensions;
import hailo.Point;
import commands.PressTrigger;
import commands.PullTrigger;
import commands.Reset;
import interfaces.Movement;

public class Player extends Shooter {
	
	public Player(Point point, String name, String className) {
		super(point, name, className);
		setOnEvent("onMouseClick", new PullTrigger(this));
		setOnEvent("onMousePress", new PressTrigger(this));
		setOnEvent("onOffScreen", new Reset(this));
		this.select();
	}
	public Player(Point point) {
		this(point, "player", "Player");
	}
//	@Deprecated
//	public Player(Point point, Dimensions dimensions) {
//		super(point, dimensions, "player1", "Player");
//		this.selected = true;
//	}
	
	//case up down left right dont seem to work
	public void processKeyHold(char c) {
		switch(c) {
			case 'w': this.push(Movement.UPWARDS);
			break;
			case 'a': this.push(Movement.LEFTWARDS);
	        break;
			case 's': this.push(Movement.DOWNWARDS);
	        break;
			case 'd': this.push(Movement.RIGHTWARDS);
	        break;
			case 't': onEvent("onMousePress");
			break;
			case 'c': onEvent("onCollision");
	        break;
		}
	}
	public void processKeyDown(char c) {
		switch(c) {
	  		case '1': this.gun = machineGun;
	  		break;
	  		case '2': this.gun = sniperRifle;
		  	break;
		  	case '3': this.gun = pistol;
		  	break;
		  	case '4': this.gun = shotgun;
		  	break;
		  	//sneaky mouseclick simulation
		  	case 't': onEvent("onMouseClick");
		  	break;
		  	case 'r': reload();
		  	break;
		}
	}
	public void onKeyDown(char c) {
	    processKeyDown(c);
	}
	public void onKeyHold(char c) {
		super.onEvent("onKeyHold");
		processKeyHold(c);
  	}
	//clicking anywhere now triggers mouse actions
	@Override
	public boolean isTarget() {
		return true;
	}
}