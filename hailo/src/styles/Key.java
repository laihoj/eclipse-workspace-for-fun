package styles;

import hailo.Attribute;
import hailo.Dimensions;
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

public class Key extends Button {
	public Key(String name) {
		super(name);
		this.fill = 		new Fill(new Color(0, 132, 180));
		this.stroke = 		new Stroke((Color)null);
		this.rectMode = 	new RectMode(PConstants.CORNER);
		this.textSize = 	new TextSize(15);
		this.textAlign = 	new TextAlign(PConstants.CENTER);
		this.textColor = 	new TextColor(new Color(0,0,0));
		this.dimensions = 	new Dimensions();
		this.radius = 		new Radius(5);
		this.shape = 		new Shape("rectangle");
	}
	public class Hovering extends Button {
		public Hovering(String name) {
			super(name);
			this.fill = new Fill(new Color(0, 200, 180));
		}
	}
	public class Pressed extends Button {
		public Pressed(String name) {
			super(name);
			this.fill = new Fill(new Color(255,255,255));
		}
	}
	
}
