import processing.core.PApplet;
import processing.core.PConstants;
import widgets.Label;
import widgets.StateBox;
import displays.GradientRect;
import hailo.*;
import hailo.Attribute.Fill;
import hailo.Attribute.Radius;
import hailo.Attribute.RectMode;
import hailo.Attribute.Shape;
import hailo.Attribute.Stroke;


public class StateboxExample extends PApplet {
	public static void main(String[] args) {
		PApplet.main("StateboxExample");
	}

	public void settings() {
		size(360,640);
	}

	public void setup() {
		frameRate(60);
		new App(this, Logging.DEBUG);
		
		/*
		 * importing styles
		 * */
		
		new styles.Container("View");
		new styles.Grid("Grid");
		new styles.StateBox("StateBox");
		
		View MAIN_MENU = new View(new Point(), "Main menu", "View");
		MAIN_MENU.add(new GradientRect(0,132,180,0,200,180));
		
		int cells = 10;
		int Width = App.width() / cells;
		String[] styleNames = {"Red", "Green", "Blue"};
		float ratio = (float)App.height() / App.width();
		for(int i = 0; i < cells; i++) {
			for(int j = 0; j < floor(ratio * cells); j++) {
				MAIN_MENU.add(new StateBox(new Point(Width * i + i, Width * j + j), "box", styleNames));
			}
		}
	}

	public void draw() {}	
}