package widgets;

import hailo.App;
import hailo.Container;
import hailo.Dimensions;
import hailo.Point;
import commands.GoBack;

public class NavBar extends Container {
	public NavBar() {
		super(new Point(0, 0), "Navigation Bar", "NavigationBar");
		this.add(new Button(new Point(), "Return", "Button", new GoBack()));
		App.navigation_bar = this;
	}
}