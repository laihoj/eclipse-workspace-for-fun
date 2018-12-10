package hailo;

public class View extends Widget {
//	public View() {
//		this("ANONYMOUS_VIEW");
//	}
	public View(Point point, String name, String className) {
		super(point, name, className);
		App.add(this);
	}
	
//	@Deprecated
//	public View(Point point, Dimensions dimensions, String name, String className) {
//		super(point, dimensions, name, className);
//		App.add(this);
////		if(App.active_view == null) {
////			App.activate(this);
////		}
//	}
//	@Deprecated
//	public View(Point point, Dimensions dimensions, String name) {
//		this(point, dimensions, name, "View");
//	}
//	@Deprecated
//	public View(String name) {
//		this(null,(Dimensions)null,name);
//	}
	
//	public String getName() {
//		return this.name;
//	}
//
//	public String toString() {
//		return this.getName();
//	}
//	
	@Override
	public boolean isTarget() {
		return false;
	}
}