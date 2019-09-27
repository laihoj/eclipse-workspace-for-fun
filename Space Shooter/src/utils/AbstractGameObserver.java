package utils;

import hailo.Dimensions;
import hailo.Point;
import hailo.Widget;
import interfaces.GameInterface;

abstract public class AbstractGameObserver extends Widget implements GameInterface {
	
	
	
	public AbstractGameObserver(Point point, String name, String className) {
		super(point, name, className);
	}
//	@Deprecated
//	public AbstractGameObserver(Point point, Dimensions dimensions, String name, String className) {
//		super(point, dimensions, name, className);
//	}
	public void goOffScreen() {
		this.onOffScreen();
	}
	public void collide() {
		this.onEvent("onCollision");
	}
	
}
