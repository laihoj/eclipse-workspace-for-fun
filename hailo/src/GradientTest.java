import processing.core.PApplet;
import displays.GradientRect;
import hailo.*;


public class GradientTest extends PApplet {
	public static void main(String[] args) {
		PApplet.main("GradientTest");
	}

	public void settings() {
		size(360,640);
	}

	public void setup() {
		/*
		 * Framerate is defined in setup, not settings (Try to just remember this)
		 * */
		frameRate(60);
		
		new App(this, Logging.DEBUG);
		
		
		
		View MAIN_MENU = new View(new Point(), "Main menu", "View");
		MAIN_MENU.add(new GradientRect(0,132,180,0,200,180));
//		MAIN_MENU.add(new GradientRect(0,0,0,120,120,120));
	}
	
	public void draw() {}	
}