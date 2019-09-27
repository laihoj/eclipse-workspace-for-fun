package styles;

import hailo.Attribute;
import hailo.Attribute.Fill;
import hailo.Attribute.Shape;
import hailo.Attribute.Stroke;
import hailo.Color;
import hailo.Dimensions;

public class Ship1 extends GameObject {
	public Ship1(String name) {
		super(name);
		this.fill 		= 	new Fill(255,0,0);
		this.stroke 	= 	new Stroke((Color)null);
		this.shape 		= 	new Shape("ellipse");
		this.dimensions = 	new Dimensions(30,30);
	}
	static public class Hovering extends Ship1 {
		public Hovering(String name) {
			super(name);
		}
	}
}
