package SleekUtils;
import hailo.Dimensions;

public class NodeStyle extends NodeCollectionStyle {

	public NodeStyle(String name) {
		super(name);
		this.dimensions = new Dimensions(100);
	}

}
