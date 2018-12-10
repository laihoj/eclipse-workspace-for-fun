package widgets;

import hailo.Point;
import hailo.View;
import commands.Navigate;

public class Navigation_Button extends Button {
	
	public Navigation_Button(Point point, String name, String className, View target) {
		super(point, name, className, new Navigate(target));
	}
//	public Navigation_Button(Point point, View target) {
//		super(new Navigate(target), target.name());
//	}
//
//	public Navigation_Button(View target) {
//		super(new Navigate(target), target.name());
//	}
}