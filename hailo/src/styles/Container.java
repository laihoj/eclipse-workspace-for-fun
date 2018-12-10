package styles;

import hailo.Attribute;
import hailo.Attribute.Fill;
import hailo.Attribute.Radius;
import hailo.Attribute.Stroke;
import hailo.Attribute.TextAlign;
import hailo.Attribute.TextColor;
import hailo.Attribute.TextSize;
import hailo.Attribute.RectMode;
import hailo.Attribute.Shape;
import processing.core.PConstants;
import hailo.Color;
import hailo.Dimensions;
import hailo.Style;

public class Container extends Style {
	public Container(String name) {
		super(name);
		this.fill = 		new Fill((Color)null);
		this.stroke = 		new Stroke(new Color(0,0,0));
		this.rectMode = 	new RectMode(PConstants.CORNER);
		this.shape = 		new Shape("rectangle");
		this.dimensions = 	new Dimensions();
	}
}
