package SleekUtils;
import hailo.Color;
import hailo.Dimensions;
import hailo.App;
import hailo.Attribute.Fill;
import styles.Button;

public class NavButtonStyle extends Button {

	public NavButtonStyle(String name) {
		super(name);
		setFill(new Color(255,255,255));
		setDimensions(new Dimensions(App.width() / 3, App.height() / 20));
	}
	
	public class NavButtonStyleHovering extends NavButtonStyle {
		public NavButtonStyleHovering(String name) {
			super(name);
			this.fill = new Fill(new Color(225,225,225));
		}
	}
	
	public class NavButtonStylePressed extends NavButtonStyle {
		public NavButtonStylePressed(String name) {
			super(name);
			this.fill = new Fill(new Color(205,205,205));
		}
	}
}
