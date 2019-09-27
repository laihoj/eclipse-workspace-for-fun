package utils;

import gameObjects.Shooter;
import interfaces.Intelligent;

public abstract class Intelligence implements Intelligent {
	public Shooter parent;
	public Intelligence(Shooter widget) {
		this.parent = widget;
	}
//	public void apply() {}
}
