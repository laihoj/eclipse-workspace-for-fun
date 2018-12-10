package hailo;

import hailo.Attribute.Shape;

abstract public class EllipseWidget extends Widget {
	public EllipseWidget(Point point, String name, String className) {
		super(point, name, className);
	}
	public boolean isTarget() {
		return App.isTargetEllipse(this.point, this.dimensions());
	}
	public class Ellipse extends Style {
		public Ellipse(String name) {
			super(name);
			this.shape = new Shape("ellipse");
		}
	}
//	public int getDiameter() {
//		return this.dimensions().diameter();
//	}
//	public int getRadius() {
//		return this.dimensions().radius();
//	}
}