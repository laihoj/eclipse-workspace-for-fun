package styles;

import hailo.Attribute.EllipseMode;
import hailo.Attribute.Fill;
import hailo.Attribute.RectMode;
import hailo.Attribute.Shape;
import hailo.Attribute.Stroke;
import hailo.Style;
import processing.core.PApplet;

abstract public class GameObject extends Style {
	public GameObject(String name) {
		super(name);
		this.ellipseMode = 	new EllipseMode(PApplet.CENTER);
		this.rectMode = 	new RectMode(PApplet.CENTER);
	}
}
