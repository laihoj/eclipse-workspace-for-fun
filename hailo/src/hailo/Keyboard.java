package hailo;

import hailo.KeyboardListener;
import commands.DoNothing;
//import processing.core.PApplet;
//import processing.core.PVector;
import processing.core.PVector;
import widgets.Button;



public class Keyboard {
	App parent;
	Container rows;
	boolean active;
	public Keyboard(App parent) {
		this.parent = parent;
		deactivate();
		String row0chars = "1234567890";
		String row1chars = "qwertyuiop";
		String row2chars = " asdfghjkl";
		String row3chars = "zxcvbnm";
//		rows = new Container(new Point(0,parent.height/2), new Dimensions(parent.width, parent.height/2));
		rows = new Container(new Point(0,App.height() /2), "keyboard", "Keyboard");
//		Container row0 = new Container(new Point(),new Dimensions(100,parent.width));
		Container row0 = new Container(new Point(), "row0", "Container");
		Container row1 = new Container(new Point(), "row1", "Container");
		Container row2 = new Container(new Point(), "row2", "Container");
		Container row3 = new Container(new Point(), "row3", "Container");
		rows.add(row0).add(row1).add(row2).add(row3);
		rows.floatDown();
		for (char c : row0chars.toCharArray()) {
			row0.add(new Key(c));
		}
		for (char c : row1chars.toCharArray()) {
			row1.add(new Key(c));
		}
		for (char c : row2chars.toCharArray()) {
			row2.add(new Key(c));
		}
		for (char c : row3chars.toCharArray()) {
			row3.add(new Key(c));
		}
	}
	public void display() {
		if(active) {
			rows.display();
		}
	}
	
	public void listen() {
		if(active) {
			rows.listen();
		}
	}
	public void compute() {
		if(active) {
			rows.compute();
		}
	}
	public void activate() {
		this.active = true;
	}
	public void deactivate() {
		this.active = false;
 	}
	public void toggle() {
		this.active = !this.active;
	}
	
	class Key extends Button {
		
		Key(char c) {
			super(new Point(), ""+c,"Key",new DoNothing());
			setOnEvent("onMousePress", new BroadcastKeyPress(c));
			setOnEvent("onMouseRelease", new BroadcastKeyRelease(c));
//			setOnMousePress(new BroadcastKeyPress(c));
//			setOnMouseRelease(new BroadcastKeyRelease(c));
		}
	}
	
	class BroadcastKeyPress implements Command {
		char key;
		BroadcastKeyPress(char key) {
			this.key = key;
		}
		public void execute() {
			System.out.println("executing key press broadcast for " + key);
			System.out.println(key);
			KeyboardListener listener = parent.active_view.keyboardListener;
			for (char c : listener.keys.keySet()) {
				if (key == c) {
					boolean unknownKey = listener.keys.get(key) == null;
					if(!unknownKey && !listener.keys.get(c)) {
						listener.keysPressed.add(c);						
					}
					listener.keys.put(c, true);
				}
			}
		}
		public void undo() {}
		public void queue() {
			System.out.println("instead of queueing key press broadcast, executing it");
			this.execute();
		}
	}
	class BroadcastKeyRelease implements Command {
		char key;
		BroadcastKeyRelease(char key) {
			this.key = key;
		}
		public void execute() {
			System.out.println("executing key release broadcast for " + key);
			KeyboardListener listener = parent.active_view.keyboardListener;
			for (char c : listener.keys.keySet()) {
				if (key == c) {
					listener.keys.put(c, true);
					listener.keysReleased.add(c);
				}
			}
		}
		public void undo() {}
		public void queue() {
			System.out.println("instead of queueing key release broadcast, executing it");
			this.execute();
		}
	}
}
