package styles;

import hailo.Style;
import hailo.Attribute;
import hailo.Attribute.Fill;
import hailo.Attribute.Shape;
import hailo.Attribute.Stroke;
import hailo.Dimensions;

public class Turret extends GameObject {
	public Turret(String name) {
		super(name);
		this.fill = 	new Fill(255,255,255);
		this.stroke = 	new Stroke(0,0,0);
		this.shape = 	new Shape("ellipse");
		this.dimensions = new Dimensions(50,50);
	}
}
