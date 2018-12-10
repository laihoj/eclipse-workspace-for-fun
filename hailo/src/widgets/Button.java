package widgets;

import hailo.App;
import hailo.Command;
import hailo.Dimensions;
import hailo.Logging;
import hailo.Point;
import hailo.RectangleWidget;
import commands.*;

/***********************************************************************************************/
public class Button extends RectangleWidget implements Command {
	Command command = null;
	Label label = null;
	
	public Button(Point point, String name, String className, Command command) {
		super(point, name, className);
		setOnEvent("onMouseRelease", command);
		this.label = new Label(new Point(this.point().x() + this.dimensions().width() / 2, this.point().y() + this.dimensions().height() / 2) , name, "Label");
		this.add(label);
	}
	
	public Button(Point point, String name, String className) {
		this(point, name, className, new DoNothing());
	}
	
	public Button setLabel(Label label) {
		this.label = label;
		return this;
	}
	//not tested
	public Button setLabel(String label) {
		this.label = new Label(this.point(), label, "Label");
		return this;
	}
	
	public Button setPoint(Point point) {
		super.setPoint(point);
		this.readjustLabel();
		return this;
	}
	public Button readjustLabel() {
		Label label = this.label;
		if(label != null) {
			label
			.setPoint(
					new Point(
							point().x() 
							+ dimensions()
							.width()
									/ 2, 
									point().y() 
									+ this.dimensions()
									.height() 
											/ 2));
			
		} else {
			new Print(name() + " has no label", Logging.WARNING);
		}
		return this;
	}
	
	@Override
	public Button setDimensions(Dimensions dimensions) {
		super.setDimensions(dimensions);
		this.readjustLabel();
		return this;
	}
	@Deprecated
	public Button setCommand(Command command) {
		this.command = command;
		return this;
	}

	@Override
	public void display() {
		super.display();
		this.label.display();
	}
	@Override
	public void listen() {
		super.listen();
		this.label.listen();
	}

	public void execute() {
		if(command != null) {
			System.out.println("Button command executed");
			this.command.execute();
		}
	}
	
	public void undo() {
		if(command != null) {
			this.command.undo();
		}
	}

	// unlike normal commands (which extend AbstractCommand {button extends
	// widget}), queue needs to be implemented
	public void queue() {
		System.out.println("Button Command queued");
		App.queue(this);
	}
}