package hailo;

import hailo.App;
import hailo.App.KeyboardActivities;
import hailo.App.MouseActivities;
import hailo.App.Selectable;
import processing.core.PVector;

abstract public class Observer implements MouseActivities, KeyboardActivities, Selectable {
	public boolean pressed, hovering, selected;
	public String key;
	
	/* Mouse stuff */
	public void hoverMouse(PVector mouse) {
		if (this.isTarget()) {
			this.hovering = true;
			this.onMouseHover();
		} else {
			if (this.hovering) {
				this.onMouseHoverOver();
				this.hovering = false;
			}
		}
	}
	
	public void clickMouse(PVector mouse) {
		if (this.isTarget()) {
			this.onMouseClick();
		}
	}
	
	public void pressMouse(PVector mouse) {
		if (this.isTarget()) {
			this.pressed = true;
			this.onMousePress();
		} else
		if (this.isSelected()) {
			this.onMousePress();
		}
	}

	public void dragMouse(PVector mouse) {
		if (this.pressed && PVector.dist(new PVector(App.pmouseX, App.pmouseY), new PVector(App.mouseX, App.mouseY)) > 0) {
			this.onMouseDrag(mouse);
		}
	}

	public void releaseMouse(PVector mouse, PVector dragment) {
		if (!this.isTarget() && this.selected) {
			this.deselect();
		}
		if (this.pressed && this.isTarget()) {
			this.onMouseRelease();
			//what is this used for again? currently makes next click on buttons trigger onclicks
//			this.select();
		}
		this.pressed = false;
	}

	/* Keyboard stuff */
	//this one should be renamed: press means hold, but this should be more like key down
	public void pressKey(char c) {
		if (this.isSelected()) {
			this.onKeyDown(c);
		}
	}

	public void holdKey(char c) {
		if (this.isSelected()) {
			this.onKeyHold(c);
		}
	}

	public void releaseKey(char c) {
		if (this.isSelected()) {
			this.onKeyUp(c);
		}
	}

	/* Selectable implementations */
	public void select() {
		this.selected = true;
	}

	public void deselect() {
		this.selected = false;
	}
}