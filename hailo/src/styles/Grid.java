package styles;

import hailo.App;
import hailo.Attribute.Fill;
import hailo.Attribute.Stroke;
import hailo.Attribute.RectMode;
import hailo.Attribute.Shape;
import processing.core.PConstants;
import hailo.Color;
import hailo.Dimensions;
import hailo.Style;

public class Grid extends Style {
	public Grid(String name) {
		super(name);
		this.fill = 		new Fill((Color)null);
		this.stroke = 		new Stroke(new Color(0,0,0));
		this.rectMode = 	new RectMode(PConstants.CORNER);
		this.shape = 		new Shape("rectangle");
		this.dimensions = 	new Dimensions(App.FULL_SCREEN);
	}
}
