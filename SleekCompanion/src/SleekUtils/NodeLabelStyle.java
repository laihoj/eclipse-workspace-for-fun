package SleekUtils;
import hailo.Attribute.TextSize;
import hailo.Dimensions;

public class NodeLabelStyle extends NodeCollectionLabelStyle{

	public NodeLabelStyle(String name) {
		super(name);
		this.textSize = new TextSize((int) (super.textSize() / 1.6));
	}

}
