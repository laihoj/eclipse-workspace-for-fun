package intelligences;

import gameObjects.Shooter;
import interfaces.Movement;
import utils.AbstractGameWidget;
import utils.Intelligence;

public class Player extends Intelligence {
	public Player(Shooter self) {
		super(self);
	}
	@Override
	public void apply() {
		
	}
	public void processKeyHold(char c) {
		switch(c) {
			case 'w': parent.push(Movement.UPWARDS);
			break;
			case 'a': parent.push(Movement.LEFTWARDS);
	        break;
			case 's': parent.push(Movement.DOWNWARDS);
	        break;
			case 'd': parent.push(Movement.RIGHTWARDS);
	        break;
			case 't': parent.onEvent("onMousePress");
			break;
			case 'c': parent.onEvent("onCollision");
	        break;
		}
	}
	public void processKeyDown(char c) {
		switch(c) {
	  		case '1': parent.setGun(parent.machineGun);
	  		break;
	  		case '2': parent.setGun(parent.sniperRifle);
		  	break;
		  	case '3': parent.setGun(parent.pistol);
		  	break;
		  	case '4': parent.setGun(parent.shotgun);
		  	break;
		  	//sneaky mouseclick simulation
		  	case 't': parent.onEvent("onMouseClick");
		  	break;
		  	case 'r': parent.reload();
		  	break;
		}
	}
	public void onKeyDown(char c) {
	    processKeyDown(c);
	}
	public void onKeyHold(char c) {
		parent.onEvent("onKeyHold");
		processKeyHold(c);
  	}
	//clicking anywhere now triggers mouse actions
	public boolean isTarget() {
		return true;
	}
}
