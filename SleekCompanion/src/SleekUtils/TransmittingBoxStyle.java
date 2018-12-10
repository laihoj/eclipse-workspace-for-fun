package SleekUtils;


import hailo.App;
import hailo.Color;
import hailo.Dimensions;
import hailo.Attribute.Fill;

public class TransmittingBoxStyle extends styles.StateBox {
	public TransmittingBoxStyle(String name) {
		super(name);
		this.fill = new Fill(new Color(255, 255, 255));
		setDimensions(new Dimensions(App.width() - 10, App.height() / 20));
	}
	public class Hovering extends TransmittingBoxStyle {
		public Hovering() {
			super("StateBoxHovering");
			this.fill = new Fill(new Color(200, 200, 200));
		}
	}
	public class Pressed extends TransmittingBoxStyle {
		public Pressed() {
			super("StateBoxPressed");
			this.fill = new Fill(new Color(150, 150, 150));
		}
	}
	public class On extends TransmittingBoxStyle {
		public On() {
			super("StateBoxOn");
			this.fill = new Fill(new Color(125,160,125));
		}
	}
}