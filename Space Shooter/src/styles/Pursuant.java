package styles;

import hailo.Attribute;
import hailo.Style;
import hailo.Attribute.Fill;
import hailo.Attribute.Shape;
import hailo.Attribute.Stroke;
import hailo.Dimensions;

public class Pursuant extends GameObject {
	public Pursuant(String name) {
		super(name);
		this.fill = 	new Fill(0,100,0);
		this.stroke = 	new Stroke(0,50,0);
		this.shape = 	new Shape("ellipse");
		this.dimensions=new Dimensions(10,10);
	}
}
