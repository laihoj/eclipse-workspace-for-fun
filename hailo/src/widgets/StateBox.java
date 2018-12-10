package widgets;

import hailo.App;
import hailo.Dimensions;
import hailo.Point;
import hailo.Style;
import hailo.Widget;
import processing.core.PConstants;

public class StateBox extends Widget {
	  //boolean checked = false;
		//first dimensions is the key, second dimension is the RGB value array
		@Deprecated
		public Integer[][] states;
		public String[] styles;
		public int state = 0;
		
		public StateBox(Point point, String name, String... classNames) {
			super(point, name, "StateBox");
			String[] s = new String[classNames.length + 1];
			s[0] = "";
			for(int i = 1; i < s.length; i++) {
				s[i] = classNames[i-1];
			}
			this.styles = s;
		}
		
		public void next() {
			this.state = (this.state + 1) % (states.length);
		}
		public int nextState() {
			this.state = (this.state + 1) % (styles.length);
			return this.state;
		}
		public boolean isTarget() {
			return App.isTargetRect(this.point(), this.dimensions());
		}
		@Override
		public void onMouseRelease() {
			System.out.println("State changed to " + this.nextState());
			super.onMouseRelease();
		}
		//setstyle is called before the styles array is initialised
		@Override
		public Widget setStyle() {
			if(this.styles != null) {
				this.setStyle(this.styles[this.state]);				
			} else {
				super.setStyle();
			}
			return this;
		}
	}