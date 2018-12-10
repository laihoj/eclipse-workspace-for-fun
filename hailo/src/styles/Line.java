package styles;

import hailo.Attribute.Fill;
import hailo.Attribute.Shape;
import hailo.Attribute.Stroke;
import hailo.Attribute.StrokeWeight;
import hailo.Color;
import hailo.Dimensions;
import hailo.Style;

public class Line extends Style {
	public Line(String name) {
		super(name);
		this.fill = 		new Fill((Color)null);
		this.stroke = 		new Stroke(new Color(0,0,0));
		this.strokeWeight = new StrokeWeight(3);
		this.shape = 		new Shape("line");
		this.dimensions = 	new Dimensions(50, 0);
	}
}
