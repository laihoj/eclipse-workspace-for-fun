package styles;

import hailo.App;
import hailo.Dimensions;
import hailo.Attribute;
import hailo.Style;

public class Keyboard extends Style {
	public Keyboard(String name) {
		super(name);
		this.dimensions = new Dimensions(App.width(), App.height() / 2);
	}
}
