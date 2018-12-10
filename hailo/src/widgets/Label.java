package widgets;

import hailo.Point;
import hailo.Widget;

public class Label extends Widget {
	public Label(Point point, String name, String className) {
		super(point, name, className);
	}
//	public Label(Point point, String name) {
//		this(point, name, "Label");
//	}
	/*
	 * Labels are by nature untargettable
	 * */
	public boolean isTarget() {
		return false;
	}
}