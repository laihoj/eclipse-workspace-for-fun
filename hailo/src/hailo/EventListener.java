package hailo;

import java.util.ArrayList;

import hailo.App.Listener;

/*Important note about listeners: The outestmost widget itself does not have a listener.
 * Instead, each widget added to it is connected to a listener*/
abstract public class EventListener implements Listener {
	ArrayList<Widget> observers = new ArrayList<Widget>();

	public void add(Widget observer) {
		this.observers.add(observer);
	}
	public void remove(Widget observer) {
		this.observers.remove(observer);
	}
	public ArrayList<Widget> observers() {
		return this.observers;
	}
}