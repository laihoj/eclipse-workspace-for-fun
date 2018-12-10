package SleekUtils;
import hailo.Color;
import hailo.Dimensions;
import hailo.Style;
import hailo.Attribute.EllipseMode;
import hailo.Attribute.Fill;
import hailo.Attribute.Shape;
import hailo.Attribute.Stroke;
import processing.core.PConstants;

public class NodeCollectionStyle extends Style {
	public NodeCollectionStyle(String name) {
		super(name);
		this.dimensions = 	new Dimensions(150);
		this.stroke = 		new Stroke(new Color(0,0,0));
		this.fill = 		new Fill(new Color(220,220,220));
		this.ellipseMode =	new EllipseMode(PConstants.CENTER);
		this.shape = 		new Shape("ellipse");
	}
}
