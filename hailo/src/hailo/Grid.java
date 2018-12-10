package hailo;

public class Grid extends Container {
	public Container[][] cells;
	
	public Grid(Point point, String name, String className, int columns, int rows) {
		super(point, name, className);
		this.cells = new Container[columns][rows];
//Have all cells use this dimensions object, that way changing one changes all
		Dimensions cellDims = new Dimensions(this.dimensions().width() / columns, this.dimensions().height() / rows);
		for(int j = 0; j < rows; j++) {
			for(int i = 0; i < columns; i++) {
				cells[i][j] = new Container(
						new Point(
								this.point().x() + cellDims.width() * i, 
								this.point().y() + cellDims.height() * j), 
						"Cell (" + i + ", " + j + ")", 
						"Container");
			}
		}
	}
	
	@Override
	public void display() {
		super.display();
		for(Container[] row: this.cells) {
			for(Container container: row) {
				container.display();
			}
		}
	}
	
	public void listen() {
		super.listen();
		for(Container[] row: this.cells) {
			for(Container container: row) {
				container.listen();
			}
		}
	}
	
	public void compute() {
		super.compute();
		for(Container[] row: this.cells) {
			for(Container container: row) {
				container.compute();
			}
		}
	}
}