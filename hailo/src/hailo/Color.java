package hailo;

public class Color {
	private int r, g, b;
	public Color(int r, int g, int b) {
		this.r = (int) App.limit(r, 0, 255);
		this.g = (int) App.limit(g, 0, 255);
		this.b = (int) App.limit(b, 0, 255);
	}
	public int r() {
		return this.r;
	}
	public int g() {
		return this.g;
	}
	public int b() {
		return this.b;
	}
	public String toString() {
		return "(" + r() + ", " + g() + ", " + b() + ")";
	}
}
