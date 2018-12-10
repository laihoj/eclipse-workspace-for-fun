package hailo;

//import hailo.App.EventListener;
import processing.core.PVector;

public class MouseListener extends EventListener {
	boolean wasMousePressed = false;
	PVector mousePos = new PVector(0, 0);
	PVector prevMousePos = new PVector(0, 0);
	PVector dragment = new PVector(0, 0);

	public MouseListener() {
	}

	public void listen() {
		for (Observer observer : this.observers) {
			observer.hoverMouse(this.mousePos);
		}
		if (App.mousePressed) {
			this.mousePos = new PVector(App.mouseX, App.mouseY);
//			for (Observer observer : this.observers) {
//				observer.pressMouse(this.mousePos);
//			}
			if (!wasMousePressed) {	//first press == click
				this.dragment.setMag(0);
				this.prevMousePos = new PVector(App.mouseX, App.mouseY);
				for (Observer observer : this.observers) {
					observer.clickMouse(this.mousePos);
				}
			} else { //subsequent presses == presses
				for (Observer observer : this.observers) {
					observer.pressMouse(this.mousePos);
				}
			}
			if (this.mousePos != this.prevMousePos) {	//drags
				this.dragment = PVector.sub(this.prevMousePos, this.mousePos);
				for (Observer observer : this.observers) {
					observer.dragMouse(this.dragment);
				}
			}
		}
		if (wasMousePressed && !App.mousePressed) { //mouse released
			for (Observer observer : this.observers) {
				observer.releaseMouse(mousePos, dragment);
			}
		}

		this.prevMousePos = new PVector(mousePos.x, mousePos.y);
		this.wasMousePressed = App.mousePressed;
	}
}
