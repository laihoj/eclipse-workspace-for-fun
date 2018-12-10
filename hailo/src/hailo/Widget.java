package hailo;


import java.util.ArrayList;
import java.util.HashMap;

import hailo.App.Display;
import hailo.App.Listener;
import commands.Print;
import processing.core.PVector;

abstract public class Widget extends Observer {
	String name;
	String className;
	Style style;
	ArrayList<Display> displayables = new ArrayList<Display>();
	ArrayList<Widget> children = new ArrayList<Widget>();
	MouseListener mouseListener;
	KeyboardListener keyboardListener;
	ArrayList<EventListener> listeners  = new ArrayList<EventListener>();
	HashMap<String, Command> onEvents = new HashMap<String, Command>();
	
	Point point;
	
	public boolean disabled = false;

	
	public Widget(Point point, String name, String className) {
		this.name = name;
		this.mouseListener = new MouseListener();
		this.keyboardListener = new KeyboardListener();
		this.listeners.add(this.mouseListener);
		this.listeners.add(this.keyboardListener);
		this.point = point;
		this.className = className;
		setStyle();
	}
	
	public Widget setName(String name) {
		this.name = name;
		return this;
	}
	
	public Dimensions dimensions() {
		if(this.style() != null) {
			return this.style().dimensions();
		} else return null;
		
	}
	public Point point() {
		return this.point;
	}
	
	public void disable() {
		this.disabled = true;
	}
	public void enable() {
		this.disabled = false;
	}
	
	public ArrayList<EventListener> listeners() {
		return this.listeners;
	}
	
	public Widget add(EventListener listener) {
		this.listeners().add(listener);
		return this;
	}
	
	public Widget remove(EventListener listener) {
		this.listeners().remove(listener);
		return this;
	}
	
	public Widget add(Display displayable) {
		if(displayable != null) {
			this.displayables.add(displayable);
		}
		return this;
	}
	
	public Widget remove(Display displayable) {
		if(displayable != null) {
			this.displayables.remove(displayable);
		}
		return this;
	}
	
	public Widget add(Widget child) {
		if(child != null) {
			this.children.add(child);
			for(EventListener listener: this.listeners) {
				listener.add(child);
				new Print(child.name + " added to " + this.name + " and to listener of class " + listener.getClass(), Logging.ALL);
			}			
		}
		return this;
	}
	
	public Widget remove(Widget child) {
		this.children.remove(child);
		for(EventListener listener: this.listeners) {
			listener.remove(child);
		}
		return this;
	}
	
	public Widget setOnEvent(String event, Command command) {
		this.onEvents.put(event, command);
		return this;
	}
	@Deprecated
	public Widget setOnMouseHover(Command command) {
		this.setOnEvent("onMouseHover", command);
		return this;
	}
	@Deprecated
	public Widget setOnMouseHoverOver(Command command) {
		this.setOnEvent("onMouseHoverOver", command);
		return this;
	}
	@Deprecated
	public Widget setOnMousePress(Command command) {
		this.setOnEvent("onMousePress", command);
		return this;
	}
	@Deprecated
	public Widget setOnMouseDrag(Command command) {
		this.setOnEvent("onMouseDrag", command);
		return this;
	}
	@Deprecated
	public Widget setOnMouseRelease(Command command) {
		this.setOnEvent("onMouseRelease", command);
		return this;
	}
	@Deprecated
	public Widget setOnKeyDown(Command command) {
		this.setOnEvent("onKeyDown", command);
		return this;
	}
	@Deprecated
	public Widget setOnKeyHold(Command command) {
		this.setOnEvent("onKeyHold", command);
		return this;
	}
	@Deprecated
	public Widget setOnKeyUp(Command command) {
		this.setOnEvent("onKeyUp", command);
		return this;
	}
	
	public void onEvent(String event) {
		if(onEvents.get(event) != null) {
			new Print(name + ": " + "On "+event+" queued", Logging.LOGGING);
			onEvents.get(event).queue();
		}
	}
	@Deprecated
	public void onMouseHover() {
		new Print(this.name + " hovering", Logging.LOGGING);
		this.setStyle("Hovering");
		if(onEvents.get("onMouseHover") != null) {
			new Print(name + ": On Mouse Hover queued", Logging.LOGGING);
			onEvents.get("onMouseHover").queue();
		}
	}
	@Deprecated
	public void onMouseHoverOver() {
		new Print(this.name + " hover over", Logging.LOGGING);
		this.setStyle();
		if(onEvents.get("onMouseHoverOver") != null) {
			new Print(name + ": On Mouse Hover over queued", Logging.LOGGING);
			onEvents.get("onMouseHoverOver").queue();
		}
	}
	@Deprecated
	public void onMouseClick() {
		System.out.println(this.name + " mouse click");
		if(onEvents.get("onMouseClick") != null) {
			new Print(name + ": On Mouse click queued", Logging.LOGGING);
			onEvents.get("onMouseClick").queue();
		}
	}
	@Deprecated
	public void onMousePress() {
		new Print(this.name + " mouse press", Logging.LOGGING);
		this.setStyle("Pressed");
		if(onEvents.get("onMousePress") != null) {
			new Print(name + ": On Mouse press queued", Logging.LOGGING);
			onEvents.get("onMousePress").queue();
		}
	}
	@Deprecated
	public void onMouseDrag(PVector mouse) {
		if(onEvents.get("onMouseDrag") != null) {
			new Print(name + ": On Mouse drag queued", Logging.LOGGING);
			onEvents.get("onMouseDrag").queue();
		}
	}
	@Deprecated
	public void onMouseRelease() {
		this.setStyle();
		new Print(this.name + " mouse release", Logging.LOGGING);
		if(onEvents.get("onMouseRelease") != null) {
			new Print(name + ": On Mouse release queued", Logging.LOGGING);
			onEvents.get("onMouseRelease").queue();
		}
	}
	@Deprecated
	public void onKeyDown(char c) {
		if(onEvents.get("onKeyDown") != null) {
			new Print(name + ": On Key Down queued", Logging.LOGGING);
			onEvents.get("onKeyDown").queue();
		}
	}
	@Deprecated
	public void onKeyHold(char c) {
		if(onEvents.get("onKeyHold") != null) {
			new Print(name + ": On Key hold queued", Logging.LOGGING);
			onEvents.get("onKeyHold").queue();
		}
	}
	@Deprecated
	public void onKeyUp(char c) {
		if(onEvents.get("onKeyUp") != null) {
			new Print(name + ": On Key hold queued", Logging.LOGGING);
			onEvents.get("onKeyUp").queue();
		}
	}

	public boolean isSelected() {
		return selected;
	}
	
	public boolean isTarget() {
		return App.isTarget(this);
	}

	public Widget setX(float x) {
		this.point().setX(x);
		return this;
	}
	
	public Widget setY(float y) {
		this.point().setY(y);
		return this;
	}
	
	public Widget setPoint(Point point) {
		this.point = point;
		return this;
	}
	
	public Widget setClassName(String className) {
		this.className = className;
		return this;
	}
	
	
	public Widget setDimensions(Dimensions dimensions) {
		this.dimensions().set(dimensions);
		return this;
	}
	
	public Widget setStyle(String suffix) {
		String stylename = this.className() + suffix;
		Style retreivedStyle = App.getStyle(stylename);
		if(retreivedStyle != null) {
			if(this.style != null) {
				new Print("Current style " + this.style.name + " will be overwritten by " + retreivedStyle.name, Logging.ALL);
			} else {
				new Print("Setting style as " + retreivedStyle.name, Logging.ALL);
			}
			this.style = new Style(retreivedStyle);
//			this.style = retreivedStyle;
			{
				Dimensions dims = this.style().dimensions();//.dimensions();
				if(dims != null) {
					this.setDimensions(dims);
				}
			}
			App.redraw();
		} else {
			new Print("Style " + stylename + " set failed, not found!", Logging.DEBUG);
		}
		return this;
	}
	//searches for default
	public Widget setStyle() {
		return setStyle("");
	}
	
	
	
//	@Deprecated
//	public int getWidth() {
//		return this.dimensions.getWidth();
//	}
//	
//	@Deprecated
//	public int getHeight() {
//		return this.dimensions.getHeight();
//	}
//	
//	@Deprecated
//	public String getName() {
//		return this.name;
//	}
//	
//	@Deprecated
//	public String getClassName() {
//		return this.className;
//	}
	
	public Command event(String event) {
		return onEvents().get(event);
	}
	
	public HashMap<String, Command> onEvents() {
		return this.onEvents;
	}
	
	public ArrayList<Widget> children() {
		return this.children;
	}
	
	public int size() {
		return this.children().size();
	}
	
	public Widget get(int i) {
		return this.children().get(i);
	}
	
	public Style style() {
		return this.style;
	}
	
	public int width() {
		return this.dimensions().width();
	}
	
	public int height() {
		return this.dimensions().height();
	}
	
	public float x() {
		return this.point().x();
	}
	
	public float y() {
		return this.point().y();
	}
	
	public String name() {
		return this.name;
	}
	
	public String className() {
		return this.className;
	}
	
	public void listen() {
		if(!disabled) {
			for(Listener listener: this.listeners) {
				listener.listen();
			}
			for (Widget child : this.children) {
				child.listen();
			}
		}
	}
	
	/*
	 * Displays self, then displays all displayables, and lastly calls all childrens display functions
	 * */
	public void display() {
		if(!disabled) {
			for (Display displayable : this.displayables) {
				displayable.display();
			}
			App.apply(this);
			App.display(this);
			for (Widget child : this.children) {
				child.display();
			}
		}
	}
	//use this to perform any internal adjustments
	public void compute() {
		if(!disabled) {
			for (Widget child : this.children) {
				child.compute();
			}
		}		
	}
	
}