package SleekUtils;

import commands.Print;
import hailo.Dimensions;
import hailo.Logging;
import hailo.Point;
import widgets.Label;
import widgets.StateBox;

public class TransmittingStateBox extends StateBox {
	Label label;
	public TransmittingStateBox(Point point, String name, String[] classNames) {
		super(point, name, classNames);
		this.label = new Label(new Point(this.point().x() + this.dimensions().width() / 2, this.point().y() + this.dimensions().height() / 2) , name, "Label");
		this.add(label);
	}
	public TransmittingStateBox setPoint(Point point) {
		super.setPoint(point);
		this.readjustLabel();
		return this;
	}
	public TransmittingStateBox readjustLabel() {
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
	public TransmittingStateBox setDimensions(Dimensions dimensions) {
		super.setDimensions(dimensions);
		this.readjustLabel();
		return this;
	}
	
}