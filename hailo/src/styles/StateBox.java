package styles;

import hailo.Color;
import hailo.Dimensions;
import hailo.Style;
import hailo.App;
import hailo.Attribute;
import hailo.Attribute.Fill;
import hailo.Attribute.Radius;
import hailo.Attribute.RectMode;
import hailo.Attribute.Shape;
import hailo.Attribute.Stroke;
import hailo.Attribute.TextAlign;
import hailo.Attribute.TextColor;
import hailo.Attribute.TextSize;
import processing.core.PConstants;

public class StateBox extends Style {
	public StateBox(String name) {
		super(name);
		this.stroke = 		new Stroke((Color)null);
		this.rectMode = 	new RectMode(PConstants.CORNER);
		this.fill = 		new Fill(new Color(127, 127, 127));
		this.shape = 		new Shape("rectangle");
		this.radius = 		new Radius(5);
		this.dimensions = 	new Dimensions(App.width() / 10, App.width() / 10);
	}
	public class Hovering extends StateBox {
		public Hovering() {
			super("StateBoxHovering");
			this.fill = new Fill(new Color(200, 200, 200));
		}
	}
	public class Pressed extends StateBox {
		public Pressed() {
			super("StateBoxPressed");
			this.fill = new Fill(new Color(150, 150, 150));
		}
	}
	public class Red extends StateBox {
		public Red() {
			super("StateBoxRed");
			this.fill = new Fill(new Color(255, 0, 0));
		}
	}
	public class Green extends StateBox {
		public Green() {
			super("StateBoxGreen");
			this.fill = new Fill(new Color(0, 255, 0));
		}
	}
	public class Blue extends StateBox {
		public Blue() {
			super("StateBoxBlue");
			this.fill = new Fill(new Color(0, 0, 255));
		}
	}
}
