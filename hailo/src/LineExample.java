import processing.core.PApplet;
import widgets.Label;
import widgets.Line;
import hailo.*;


public class LineExample extends PApplet {
	public static void main(String[] args) {
		PApplet.main("LineExample");
	}

	public void settings() {
		size(360,640);
	}

	public void setup() {
		frameRate(60);
		new App(this, Logging.DEBUG);
		
		View MAIN_MENU = new View(new Point(), "Main menu", "View");
		
		/*
		 * Appearance of line is defined as style
		 * */
		Line line = new Line(new Point(width/2, height/2), "This is an example line", "Line");
		MAIN_MENU.add(line);
		
	}
	public void draw() {}	
}