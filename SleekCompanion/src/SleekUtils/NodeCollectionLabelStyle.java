package SleekUtils;
import hailo.Attribute.Fill;
import hailo.Attribute.Shape;
import hailo.Attribute.Stroke;
import hailo.Attribute.TextAlign;
import hailo.Attribute.TextSize;
import processing.core.PConstants;
import hailo.Color;
import hailo.Dimensions;
import hailo.Style;

public class NodeCollectionLabelStyle extends Style {
	public NodeCollectionLabelStyle(String name) {
		super(name);
		this.textSize = 	new TextSize(30);
		this.fill = 		new Fill(new Color(0,0,0));
		this.dimensions = 	new Dimensions();
		this.shape = 		new Shape("text");
		this.textAlign = 	new TextAlign(PConstants.CENTER);
	}
}
