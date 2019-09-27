package styles;

import hailo.Attribute;
import hailo.Attribute.Fill;
import hailo.Attribute.Shape;
import hailo.Dimensions;
import hailo.Style;

public class CannonBall extends GameObject {
	public CannonBall(String name) {
		super(name);
		this.fill = new Fill(0,0,0);
		this.shape = new Shape("ellipse");
		this.dimensions = new Dimensions(20);
	}
}
