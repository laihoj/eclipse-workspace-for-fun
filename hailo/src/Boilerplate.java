import processing.core.PApplet;
import widgets.Label;
import hailo.*;


public class Boilerplate extends PApplet {
	public static void main(String[] args) {
		PApplet.main("Boilerplate");
	}

	public void settings() {
		/*
		 * set size of screen to Samsung Galaxy S7 Edge size.
		 * size(1440/4,2560/4); 
		 * (Alternatively use fullScreen())
		 * */
		size(360,640);
	}

	public void setup() {
		/*
		 * Framerate is defined in setup, not settings (Try to just remember this)
		 * */
		frameRate(60);
		
		/*
		 * And the developer said, let there be an app!
		 * (In debugging mode, that is)
		 * */
		new App(this, Logging.DEBUG);
		
		/*
		 * importing styles
		 * */
		new styles.Container("View");
		
		/*
		 * An app can have multiple views.
		 * Here is the main menu view!
		 * */
		View MAIN_MENU = new View(new Point(), "Main menu", "View");
		
		
		/*
		 * Let's add a label (text box) to the main menu.
		 * */
		Label title = new Label(new Point(width/2, height/2), "This is an example app", "Label");
		MAIN_MENU.add(title);
		
	}
	
	/*
	 * This function stub must be stated, otherwise the app runs only the first frame.
	 * Essentially, it makes sure the app keeps on looping (drawing?) infinitely
	 * */
	public void draw() {}	
}