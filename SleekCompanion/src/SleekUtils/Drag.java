package SleekUtils;
import hailo.AbstractCommand;
import hailo.App;
import hailo.Point;
import hailo.Widget;

public class Drag extends AbstractCommand {
		Node widget;
		public Drag(Node widget) {
			this.widget = widget;
		}
		
		public void execute() {
			Point newpoint = new Point(App.mouseX, App.mouseY);
			widget.setPosition(newpoint);
		}
	}