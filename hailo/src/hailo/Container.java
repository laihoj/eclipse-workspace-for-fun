package hailo;

public class Container extends View {
	
	public Container(Point point, String name, String className) {
		super(point, name, className);
	}

	public Container add(Widget widget) {
		super.add(widget);
		floatLeft();
		return this;
	}
	
	public void floatLeft() {
		int margin = 4;
		int Height = this.height() - margin * 2;
		int Width = this.width() / this.size() - margin * 2;
		for (int i = 0; i < this.size(); i++) {
			Widget widget = this.get(i);
			Dimensions newDims = new Dimensions(Width, Height);
			widget.style().dimensions().set(newDims);
			widget.setDimensions(newDims)
			  	  .setPoint(new Point(this.x() + margin + (Width + margin * 2) * i, this.y() + margin));;
		}
	}
	
	public void floatDown() {
		int margin = 4;
		int Height = this.height() / this.size() - margin * 2;
		int Width = this.height() - margin * 2;
		for (int i = 0; i < this.size(); i++) {
			Widget widget = this.get(i);
			Dimensions newDims = new Dimensions(Width, Height);
			widget.style().dimensions().set(newDims);
			widget.setDimensions(newDims)
				  .setPoint(new Point(this.x() + margin, this.y() + margin + (Height + margin * 2) * i));
		}
	}
}