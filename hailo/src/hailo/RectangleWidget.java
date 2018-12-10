package hailo;

import hailo.Attribute.Shape;

abstract public class RectangleWidget extends Widget {
	public RectangleWidget(Point point, String name, String className) {
		super(point, name, className);
	}
	
	public boolean isTarget() {
		return App.isTargetRect(this.point, this.dimensions());
	}
	
	public class Rectangle extends Style {
		public Rectangle(String name) {
			super(name);
			this.shape = new Shape("rectangle");
		}
	}
}