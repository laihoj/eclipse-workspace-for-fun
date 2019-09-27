package styles;

import hailo.Attribute.Fill;
import hailo.Attribute.Shape;
import hailo.Dimensions;
import hailo.Attribute;
import hailo.Style;

public class Projectile extends GameObject {
	public Projectile(String name) {
		super(name);
		this.fill = new Fill(0,0,0);
		this.shape = new Shape("ellipse");
		this.dimensions = new Dimensions(5,5);
	}
}
