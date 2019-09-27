package projectiles;

import java.util.ArrayList;

import gameObjects.Shooter;
import utils.AbstractProjectile;

public class CompoundProjectile extends AbstractProjectile {
//	ArrayList<AbstractProjectile> shots;
	public CompoundProjectile(Shooter shooter) {
		super(shooter, "pew", "Projectile");
//		this.shots = new ArrayList<AbstractProjectile>();
		// TODO Auto-generated constructor stub
	}
	
//	public void add(AbstractProjectile shot) {
//		this.shots.add(shot);
//	}
}
