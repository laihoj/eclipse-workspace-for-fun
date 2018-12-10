import processing.core.PApplet;
import widgets.Label;
import hailo.*;
import hailo.Attribute.Pull;


public class PullingExample extends PApplet {
public static void main(String[] args) {PApplet.main("PullingExample");}
public void settings() {size(360,640);}
public void setup() {
	
	
	
	
		frameRate(60);
		new App(this, Logging.DEBUG);
		
		new LabelPullLeft("Label");
		
		View MAIN_MENU = new View(new Point(), "Main menu", "View");
		
		Label title = new Label(new Point(width/2, height/2), "This is an example app", "Label");
		MAIN_MENU.add(title);
		
		
		
}public void draw(){}

public class LabelPullLeft extends styles.Label {
	LabelPullLeft(String name) {
		super(name);
		pull = new Pull("left");
	}
}
}