package hailo;

public class Attribute implements Valuable {
	Integer value;
	Color color;
	String string;
	Dimensions dimensions;
	Attribute(Integer value, Color color, String string, Dimensions dimensions) {
		this.value = value;
		this.color = color;
		this.string = string;
		this.dimensions = dimensions;
	}
	public Attribute(Integer value) {
		this(value, null, null, null);
	}
	public Attribute(Color color) {
		this(null, color, null, null);
	}
	public Attribute(String string) {
		this(null, null, string, null);
	}
	public Attribute(Dimensions dimensions) {
		this(null, null, null, dimensions);
	}
	
	public Attribute set(Integer value) {
		this.value = value;
		return this;
	}
	public Attribute set(Color color) {
		this.color = color;
		return this;
	}
	public Attribute set(String string) {
		this.string = string;
		return this;
	}
	public Attribute set(Dimensions dimensions) {
		this.dimensions = dimensions;
		return this;
	}
	
	public Integer value() {
		return this.value;
	}
	public Color color() {
		return this.color;
	}
	public String string() {
		return this.string;
	}
	public Dimensions dimensions() {
		return this.dimensions;
	}
	
	public static class Stroke extends Attribute {
		Color color;
		public Stroke(Color color) {
			super(color);
		}
		public Stroke(int r, int g, int b) {
			super(new Color(r, g, b));
		}
		public Stroke(Stroke stroke) {
			this(stroke.color().r(), stroke.color().g(), stroke.color().b());
		}
	}
	
	public static class Fill extends Attribute {
		Color color;
		public Fill(Color color) {
			super(color);
		}
		public Fill(int r, int g, int b) {
			super(new Color(r, g, b));
		}
		public Fill(Fill fill) {
			this(fill.color().r(), fill.color().g(), fill.color().b());
		}
	}
	
	public static class TextColor extends Attribute {
		Color color;
		public TextColor(Color color) {
			super(color);
		}
		public TextColor(int r, int g, int b) {
			super(new Color(r, g, b));
		}
		public TextColor(TextColor textColor) {
			this(textColor.color().r(), textColor.color().g(), textColor.color().b());
		}
	}
	
	public static class TextAlign extends Attribute {
		public TextAlign(Integer mode) {
			super(mode);
		}
	}
	
	public static class TextSize extends Attribute {
		public TextSize(Integer size) {
			super(size);
		}
		public TextSize(TextSize textSize) {
			this(textSize.value());
		}
	}
	
	public static class RectMode extends Attribute {
		public RectMode(Integer mode) {
			super(mode);
		}
		public RectMode(RectMode rectMode) {
			this(rectMode.value());
		}
	}
	public static class EllipseMode extends Attribute {
		public EllipseMode(Integer mode) {
			super(mode);
		}
		public EllipseMode(EllipseMode ellipseMode) {
			this(ellipseMode.value());
		}
	}
	public static class Radius extends Attribute {
		public Radius(Integer radius) {
			super(radius);
		}
		public Radius(Radius radius) {
			this(radius.value());
		}
	}
	public static class Shape extends Attribute {
		public Shape(String string) {
			super(string);
		}
		public Shape(Shape shape) {
			super(shape.string());
		}
	}
	public static class Pull extends Attribute {
		public Pull(String direction) {
			super(direction);
		}
		public Pull(Pull direction) {
			super(direction.string());
		}
	}
	public static class StrokeWeight extends Attribute {
		public StrokeWeight(Integer weight) {
			super(weight);
		}
		public StrokeWeight(StrokeWeight weight) {
			super(weight.value());
		}
	}
}