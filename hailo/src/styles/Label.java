package styles;

import hailo.Color;
import hailo.Dimensions;
import hailo.Style;
import hailo.Attribute;
import hailo.Attribute.Fill;
import hailo.Attribute.Shape;
import hailo.Attribute.TextAlign;
import hailo.Attribute.TextSize;
import processing.core.PConstants;

public class Label extends Style {
	public Label(String name) {
		super(name);
		this.name = name;
		this.textSize = 	new TextSize(15);
		this.textAlign = 	new TextAlign(PConstants.CENTER);
		this.fill = 		new Fill(new Color(0,0,0));
		this.shape = 		new Shape("text");
		this.dimensions = 	new Dimensions();
	}
}
