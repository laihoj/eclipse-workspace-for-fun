package intelligences;

import gameObjects.Shooter;
import utils.AbstractGameWidget;
import utils.Intelligence;

public class ShootAt extends Intelligence {
	int delay = 0;
	int frequency = 60;
	AbstractGameWidget target;
	public ShootAt(Shooter self, Shooter target) {
		super(self);
		this.target = target;
	}

	@Override
	public void apply() {
		if(this.delay == frequency - 1) {
			this.parent.setAim(parent.direction(target));
			this.parent.pullTrigger();
		}
		
		this.delay = (this.delay + 1)%frequency;
	}
}
