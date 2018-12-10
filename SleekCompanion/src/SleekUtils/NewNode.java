package SleekUtils;
import hailo.AbstractCommand;
import hailo.App;
import hailo.Point;
import hailo.Widget;

public class NewNode extends AbstractCommand {
	Node parent;
	String name;
	public NewNode(Node parent, String name) {
		this.parent = parent;
		this.name = name;
	}
	
	public void execute() {
		Node newNode2 = new Node(new Point(App.width() / 2, App.height() * 1 / 3), name, "NodeStyle");
		parent.add((Node)newNode2.setOnEvent("onMouseDrag", new Drag(newNode2)));
	}
}