package interfaces;

import utils.AbstractProjectile;

public interface Fire {
	AbstractProjectile pullTrigger();
	AbstractProjectile pressTrigger();
	AbstractProjectile fire();
}
