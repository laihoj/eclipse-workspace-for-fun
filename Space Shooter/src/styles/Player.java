package styles;

import hailo.Attribute;
import hailo.Attribute.EllipseMode;
import hailo.Attribute.Fill;
import hailo.Attribute.Shape;
import hailo.Attribute.Stroke;
import hailo.Color;
import hailo.Dimensions;
import hailo.Style;
import processing.core.PApplet;

public class Player extends GameObject {
	public Player(String name) {
		super(name);
		this.fill 		= 	new Fill(255,0,0);
		this.stroke 	= 	new Stroke((Color)null);
		this.shape 		= 	new Shape("ellipse");
		this.dimensions = 	new Dimensions(30,30);
//		this.ellipseMode = 	new EllipseMode(PApplet.CENTER);
	}
	static public class Hovering extends Player {
		public Hovering(String name) {
			super(name);
//			this.fill = new Fill(255, 200, 200);
		}
	}
}
