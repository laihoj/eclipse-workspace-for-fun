package hailo;

/***********************************************************************************************/
public class Dimensions {
	int[] dims;

	public Dimensions(int a) {
		this.dims = new int[] { a, 0 };
	}

	public Dimensions(int a, int b) {
		this.dims = new int[] { a, b };
	}

	public Dimensions(int... dims) {
		this.dims = dims;
	}
	
	public Dimensions() {
		this.dims = new int[] { 0, 0 };
	}

	public Dimensions(Dimensions dimensions) {
		this.dims = new int[dimensions.dims.length];
		for (int i = 0; i < dimensions.dims.length; i++) {
			this.dims[i] = dimensions.dims[i];
		}
		// this.dims = dimensions.dims;
	}
	public Dimensions set(Dimensions dimensions) {
		this.dims = dimensions.dims;
		return this;
	}
	
	public int dimension(int i) {
		return this.dims[i];
	}
	public int width() {
		return this.dimension(0);
	}
	public int height() {
		return this.dimension(1);
	}
	public int diameter() {
		return this.dimension(0);
	}
	public int radius() {
		return this.diameter() / 2;
	}
}

/***********************************************************************************************/