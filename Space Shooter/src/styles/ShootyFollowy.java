package styles;

import hailo.Attribute;
import hailo.Attribute.Fill;
import hailo.Attribute.Shape;
import hailo.Attribute.Stroke;
import hailo.Dimensions;
import hailo.Style;

public class ShootyFollowy extends GameObject {
	public ShootyFollowy(String name) {
		super(name);
		this.fill = 	new Fill(0,0,100);
		this.stroke = 	new Stroke(0,0,0);
		this.shape = 	new Shape("ellipse");
		this.dimensions=new Dimensions(50,50);
	}
}
