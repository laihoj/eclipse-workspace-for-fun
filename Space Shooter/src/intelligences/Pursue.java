package intelligences;

import hailo.App;
import gameObjects.Shooter;
import interfaces.Movement;
import processing.core.PVector;
import utils.AbstractGameWidget;
import utils.Intelligence;

public class Pursue extends Intelligence {
	AbstractGameWidget target;
	public Pursue(Shooter self, Shooter target) {
		super(self);
		this.target = target;
	}
	@Override
	public void apply() {
		/*push self in the direction of the target*/
		parent.go(parent.direction(target));
	}
}
