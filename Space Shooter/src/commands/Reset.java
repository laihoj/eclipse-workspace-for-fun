package commands;

import hailo.AbstractCommand;
import hailo.Logging;
import hailo.Point;
import hailo.Widget;

public class Reset extends AbstractCommand {
	Widget widget;
	Point resetPoint;
	public Reset(Widget widget) {
		this.widget = widget;
		this.resetPoint = new Point(widget.point());
	}
	/*
	 * manually sets value to x and y instead of calling setPoint.
	 * this is because otherwise everything else 
	 * that refers to the widgets point object still thinks
	 * the widget is still in the same place
	 * */
	public void execute() {
		widget.point().setX(resetPoint.x());// = resetPoint.x;
		widget.point().setY(resetPoint.y());
//		widget.point().y() = resetPoint.y;
		new Print("Reset executed", Logging.LOGGING);
	}
}
