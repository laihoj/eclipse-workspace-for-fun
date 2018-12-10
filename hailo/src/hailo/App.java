package hailo;

import java.util.ArrayList;
import java.util.HashMap;
import hailo.Attribute.Shape;
import commands.*;
import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PVector;
import processing.event.KeyEvent;
import widgets.NavBar;


//TODO: Add scheduled commands
//TODO: style file reader
public class App {
	static public PApplet parent;
	static public HashMap<String, Style> styles;// = new HashMap<String, Style>();
	
	//describes the shape of the next object to be drawn. usually set to rectangle or ellipse
	static Widget widget				= null; /* Trying not to use that, except for 'pulling' */
	static String widgetShape 			= null;
	static Color widgetTextColor 		= null;
	static Color widgetStroke 			= null;
	static Integer widgetStrokeWeight 	= null;
	static Color widgetFill 			= null;
	static Integer widgetTextSize 		= null;
	static Integer widgetTextAlign 		= null;
	static Integer widgetRectMode 		= null;
	static Integer widgetEllipseMode 	= null;
	static Integer widgetRadius 		= null;
	static Dimensions widgetDimensions 	= null;
	static String widgetPull 			= null;
	
	
	//if anything in the display should be updated, this is toggled
	static boolean needsToRedraw = true;
	
	//uses logging interface to figure out what to print out, per initialisation level of App
	public static int LOGGING_LEVEL = 0;
	
	
	static boolean mousePressed, keyPressed;
	static public int width, height;
	static public int mouseX, mouseY, pmouseX, pmouseY;
	static char key;

	public static Point TOP_LEFT;
	public static Point[] TOP_THIRDS, TOP_FOURTHS, TOP_FIFTHS, TOP_SIXTHS;
	public static Dimensions BUTTON_DEFAULT_DIMENSIONS, FULL_SCREEN;
	public static Point A_BIT_TO_THE_LEFT, A_BIT_TO_THE_RIGHT, A_BIT_UPWARDS;
	public static int DEFAULT_TEXT_SIZE;

	//pixels spent on pulled widgets:
	/* 
	 * Pulling is implemented in the following convoluted way, pay attention:
	 * For when any none-absolute positioned (as in that.pull() != 'none')
	 * is displayed, that widget 'expends' pixels from that sides it is pulled to
	 * equal to its dimensions in that respective direction.
	 * 
	 *  This expenditure is tracked in the following points
	 *  */
	
	public static Point PIXELS_PULLED_LEFT_TOP, PIXELS_PULLED_RIGHT_BOTTOM;
	
	public void pre() {
		
		mousePressed = parent.mousePressed;
		keyPressed = parent.keyPressed;
		mouseX = parent.mouseX;
		mouseY = parent.mouseY;
		pmouseX = parent.pmouseX;
		pmouseY = parent.pmouseY;
		key = parent.key;
		next();
	}
	
	public void keyEvent(KeyEvent e) {
		
		switch(e.getAction()) {
			case KeyEvent.PRESS:
				new Print("keyEvent: KeyPressed: " + e.getKey(), Logging.LOGGING);
				keyPressed(e.getKey());
				break;
			case KeyEvent.RELEASE:
				new Print("keyEvent: KeyReleased: " + e.getKey(), Logging.LOGGING);
				keyReleased(e.getKey());
				break;
			default:
				break;

		}
	}
	
	
	static public ArrayList<View> views = new ArrayList<View>();
	static ArrayList<Command> commands = new ArrayList<Command>();
	static public ArrayList<Navigate> navigationHistory = new ArrayList<Navigate>();
	static public View 		active_view 	= null;
	static public NavBar   	navigation_bar  = null;
	static public Keyboard 	keyboard 		= null;

	public App(PApplet papplet, int loggingLevel) {
		System.out.println("App starting...");
		parent = papplet;
		parent.registerMethod("pre", this);
		parent.registerMethod("keyEvent", this);

		LOGGING_LEVEL = loggingLevel;
		
		width = parent.width;
		height = parent.height;
		
		mousePressed = parent.mousePressed;
		mouseX = parent.mouseX;
		mouseY = parent.mouseY;
		pmouseX = parent.pmouseX;
		pmouseY = parent.pmouseY;
		keyPressed = parent.keyPressed;
		key = parent.key;

		TOP_LEFT = new Point(0, 0);
		TOP_THIRDS = new Point[] { new Point(TOP_LEFT), new Point(width / 3, 0), new Point(width * 2 / 3, 0) };
		TOP_FOURTHS = new Point[] { new Point(TOP_LEFT), new Point(width / 4, 0), new Point(width * 2 / 4, 0),
				new Point(width * 3 / 4, 0) };
		TOP_FIFTHS = new Point[] { new Point(TOP_LEFT), new Point(width / 5, 0), new Point(width * 2 / 5, 0),
				new Point(width * 3 / 5, 0), new Point(width * 4 / 5, 0) };
		TOP_SIXTHS = new Point[] { new Point(TOP_LEFT), new Point(width / 6, 0), new Point(width * 2 / 6, 0),
				new Point(width * 3 / 6, 0), new Point(width * 4 / 6, 0), new Point(width * 5 / 6, 0) };
		
		BUTTON_DEFAULT_DIMENSIONS = new Dimensions(width / 6 - 1, 100);
		FULL_SCREEN = new Dimensions(width, height);
		A_BIT_TO_THE_LEFT = new Point(-100, 0);
		A_BIT_TO_THE_RIGHT = new Point(100, 0);
		A_BIT_UPWARDS = new Point(0, -100);
		DEFAULT_TEXT_SIZE = 15;
		styles = new HashMap<String, Style>();
		
		new styles.Button("Button")
			.new Pressed("ButtonPressed")
			.new Hovering("ButtonHovering");
		new styles.Container("Container");
		new styles.Line("Line");
		new styles.Label("Label");
		new styles.Grid("Grid");
		new styles.NavigationBar("NavigationBar");
		new styles.Keyboard("Keyboard");
		new styles.Key("Key");
		new styles.StateBox("StateBox")
			.new Pressed()
			.new Hovering()
			.new Red()
			.new Green()
			.new Blue();
		keyboard = new Keyboard(this);
		//the keyboard is built of containers, which unfortunately are set as the active view.
		//for now lets just nullify this
		active_view = null;
		System.out.println("Active view: " + activeview());
		System.out.println("Navbar: " + navbar());
		
	}
	
	public App(PApplet papplet, boolean initing) {
		this(papplet, Logging.ALL);
		if(initing) {
			LOGGING_LEVEL = Logging.ALL;
		} else {
			LOGGING_LEVEL =  Logging.NONE;
		}
	}
	
	public App(PApplet papplet) {
		parent = papplet;
	}

	public static void putStyle(String key, Style value) {
		new Print("Setting style: " + key + ";" + value.toString(), Logging.LOGGING);
		styles.put(key, value);
	}
	static public Style getStyle(String key) {
		return styles.get(key);
	}
	static public View activeview() {
		return active_view;
	}
	
	static public NavBar navbar() {
		return navigation_bar;
	}
	static public Keyboard keyboard() {
		return keyboard;
	}
	static public Color textColor() {
		return widgetTextColor;
	}
	
	static public void add(View view) {
		views.add(view);
		if(App.active_view == null) {
			App.activate(view);
		}
	}

	static public void remove(View view) {
		views.remove(view);
	}

	static public void activate(View view) {
		active_view = view;
	}
	
	static public void goBack() {
		if(navigationHistory.size() > 0) {
			Command navigationToUndo = navigationHistory.get(navigationHistory.size() - 1);
			navigationToUndo.undo();
			navigationHistory.remove(navigationToUndo);
		}
	}
	
	static public void redraw() {
		needsToRedraw = true;
	}

	public void display() {
		if(needsToRedraw) {
			parent.background(255);
			if (navbar() != null) {
				navbar().display();
			}
			if (activeview() != null) {
				activeview().display();
			} else {
				new Print("Activate a view first!", Logging.WARNING);
			}
			if (keyboard() != null && keyboard().active) {
				keyboard().display();
			}
			needsToRedraw = false;
			new Print("Display refreshed", Logging.ALL);
		}
	}
	
	static public void apply() {
		stroke(widgetStroke);
		fill(widgetFill);
		textSize(widgetTextSize);
		textAlign(widgetTextAlign);
		rectMode(widgetRectMode);
		ellipseMode(widgetEllipseMode);
		pull(widgetPull);
	}
	
	/*
	 * Ternary operator. if App's widgetDimensions is defined, it overrides widget's own dimensions
	 * */
	static public void display(Widget widget) {
		if(widget != null) {
			Point point = widget.point();
			String name = widget.name();
			if(widgetShape != null) {
				switch(widgetShape) {
					case "rectangle":
						rect(
								point, 
								widgetDimensions, 
								widgetRadius != null ? widgetRadius : 0
										);
						break;
					case "ellipse":
						ellipse(point, widgetDimensions);
						break;
					case "text":
						text(name, point);
						break;
					case "line":
						line(point, widgetDimensions);
						break;
					default:
						new Print(name + " shape unknown, cannot display", Logging.DEBUG);
						break;
				}
			}
		}
	}
	
	
	
	/*
	 * If a style is defined as not null, apply it.
	 * For each attribute, if it is not defined, set its value (even if it set at null)
	 * */
	static public void apply(Widget widget) {
		if(widget != null) {
			//WIDGET IN QUESTION: mostly relevant for pulling
			setWidget(widget);
			Style style = widget.style();
			if(style != null) {
				//STROKE
				{
					if(style.stroke() != null) {
						Color c = style.stroke();
						setStroke(c);
					}
				}
				//STROKEWEIGHT
				{
					if(style.strokeWeight() != null) {
						Integer i = style.strokeWeight();
						setStrokeWeight(i);
					}
				}
				//FILL
				{
					if(style.fill() != null) {
						Color c = style.fill();
						setFill(c);
					}
				}
				//TEXT COLOR
				{
					if(style.textColor() != null) {
						Color c = style.textColor();
						setTextColor(c);
					}
				}
				//TEXT SIZE
				{
					if(style.textSize() != null) {
						Integer s = style.textSize();
						setTextSize(s);
					}
				}
				//TEXT ALIGN
				{
					if(style.textAlign() != null) {
						Integer s = style.textAlign();
						setTextAlign(s);
					}
				}
				//RECTMODE
				{
					if(style.rectMode() != null) {
						Integer s = style.rectMode();
						setRectMode(s);
					}
				}
				//RADIUS
				{
					if(style.radius() != null) {
						Integer s = style.radius();
						setRadius(s);
					}
				}
				//ELLIPSEMODE
				{
					if(style.ellipseMode() != null) {
						Integer s = style.ellipseMode();
						setEllipseMode(s);
					}
				}
				//SHAPE
				{
					if(style.shape() != null) {
						String s = style.shape();
						setShape(s);
					}
				}
				//DIMENSIONS
				{
					if(style.dimensions() != null) {
						Dimensions d = style.dimensions();
						setDimensions(d);
					}
				}
				//PULL
				{
					if(style.pull() != null) {
						String direction = style.pull();
						setPull(direction);
					}
				}
				apply();
			} else {
				new Print("Style not applied, null", Logging.LOGGING);
			}
		}
	}

	public void listen() {
		if (navigation_bar != null) {
			navigation_bar.listen();
		}
		if (active_view != null) {
			active_view.listen();
		}
		if (keyboard() != null && keyboard().active) {
			keyboard().listen();
		}
	}
	
	public void compute() {
		if (navbar() != null) {
			navbar().compute();
		}
		if (activeview() != null) {
			activeview().compute();
		} else {
			new Print("Activate a view first!", Logging.DEBUG);
		}
		if (keyboard() != null && keyboard().active) {
			keyboard().compute();
		}
	}

	static public void queue(Command command) {
		commands.add(command);
		new Print("Command stack size: " + commands.size(), Logging.ALL);
	}
	
	public void execute() {
		if(commands.size() == 0) {
		} else {
			Command latestCommand = commands.get(commands.size() - 1);
			latestCommand.execute();
			commands.remove(latestCommand);
			int remainingStackSize = commands.size();
			new Print("Command stack size: " + commands.size(), Logging.ALL);
			new Print("Executed, remaining stack size: " + remainingStackSize, Logging.LOGGING);
			if(remainingStackSize > 0) execute();
		}
	}

	public void next() {
		
		listen();
		
		execute();
		
		compute();
		
		display();
		
	}

	

///////////////////////////////////////////////////////////////////////////////////////////////
/***********************************************************************************************/
/////////////////////////////////////////////////////////////////////////////////////////////////


	
	public void keyPressed(char key) {
		KeyboardListener listener = App.active_view.keyboardListener;
		new Print("Hardware key " + key + " pressed", Logging.LOGGING);
		boolean unknownKey = listener.keys.get(key) == null;
		if(!unknownKey && !listener.keys.get(key)) {
			listener.keysPressed.add(key);
		}
		listener.keys.put(key, true);
	}
	
	public void keyReleased(char key) {
		KeyboardListener listener = App.active_view.keyboardListener;
		new Print("Hardware key " + key + " released", Logging.LOGGING);
		listener.keys.put(key, false);
		listener.keysReleased.add(key);
	}


/////////////////////////////////////////////////////////////////////////////////////////////////
/***********************************************************************************************/
/////////////////////////////////////////////////////////////////////////////////////////////////
	static public void println(String text) {
		new Print(text);
	}
	
	/*
	 * Returns a boolean value based on if the widget is on the screen.
	 * Note: Point is typically in upper left corner of widget, not at its center
	 * */
	static public boolean offScreen(Widget widget) {
		return widget.x() < 0 ||
				widget.x() > width ||
				widget.y() < 0 ||
				widget.y() > height;
	}
	
	/*
	 * Returns the value limited by the lower and upper boundaries
	 * */
	static public float limit(float value, float min, float max) {
		return Math.min(max, Math.max(min, value));
	}
	
	/*
	 * returns heading to one widget from other widget
	 * */
	static public float direction(Widget to, Widget from) {
		return direction(to.point, from.point); 
	}
	
	/*
	 * returns heading to one point from other point
	 * */
	static public float direction(Point to, Point from) {
		return direction(to.toPVector(), from.toPVector());
	}
	
	/*
	 * returns heading to one pvector from other pvector
	 * */
	static public float direction(PVector to, PVector from) {
		return PVector.sub(to, from).heading();
	}
	
	/*
	 * Returns a boolean value based on if the mouse is within the widget,
	 * adapted to each known shape
	 * */
	static public boolean isTarget(Widget widget) {
		if(widget != null) {
			Style style = widget.style();
			Point point = widget.point;
			Dimensions dimensions = widget.dimensions();
			if(style != null) {
				Shape shape = style.shape;
				switch(shape.string()) {
					case "rectangle":
						return isTargetRect(point, widgetDimensions == null ?  dimensions : widgetDimensions);
					case "ellipse":
						return isTargetEllipse(point, widgetDimensions == null ?  dimensions : widgetDimensions);
					case "line":
						return false;
					default:
						new Print("Shape not recognised, did not target", Logging.DEBUG);
						break;
							
				}
			}
		}
		//if made it this far, it means something went wrong, and no targeting failed
		return false;
	}
	
	/*
	 * Returns a boolean value based on if the point is within the rectangle
	 * */
	static public boolean isTargetRect(Point point, Dimensions dimensions) {
		return 	mouseX > point.x() && 
				mouseX < point.x() + dimensions.width() && 
				mouseY > point.y() && 
				mouseY < point.y() + dimensions.height();
	}

	/*
	 * Returns a boolean value based on if the point is within the ellipse
	 * */
	static public boolean isTargetEllipse(Point point, Dimensions dimensions) {
		return 	dimensions.radius() > 
				Math.sqrt((float) 
						(
							Math.pow(point.x() + dimensions.radius() - mouseX, 2
						)
							+ Math.pow(point.y() + dimensions.radius() - mouseY, 2)
					)
				);
	}

	
/////////////////////////////////////////////////////////////////////////////////////////////////
/***********************************************************************************************/
/////////////////////////////////////////////////////////////////////////////////////////////////
	
	//IMPLEMENTING PROCESSING APPLET FUNCTIONS
	static public int width() {
		return width;
	}
	
	static public int height() {
		return height;
	}
	
	static public void ellipse(Point point, Dimensions dimensions) {
		parent.ellipse(point.x(), point.y(), dimensions.diameter(), dimensions.diameter());
	}

	//use dimensions width being 0 assumption to be square
	static public void rect(Point point, Dimensions dimensions) {
		rect(point, dimensions, 0);
	}
	
	static public void rect(Point point, Dimensions dimensions, int radius) {
		rect(point.x(), point.y(), dimensions.width(), dimensions.height(), radius);
	}
	
	static public void rect(int x, int y, int width, int height, int radius) {
		rect((float)x, (float)y, (float)width, (float)height, (float)radius);
	}
	static public void rect(int x, int y, int width, int height) {
		rect(x, y, width, height, 0);
	}
	static public void rect(float x, float y, float width, float height, float radius) {
		parent.rect(x, y, width, height, radius);
	}
	
	static public void text(String s, int x, int y) {
		if(widgetTextColor != null) {
			fill(widgetTextColor);
		} else {
			new Print("tried to fill text with textcolor = null", Logging.DEBUG);
		}
		parent.text(s, x, y);
	}
	
	static public void text(String s, float x, float y) {
		text(s, (int)x, (int)y);
	}
	
	/*
	 * Lines are drawn in the polar coordinate system; dims[0] = length, dims[1] = angle in degrees.
	 * 0 is to the right, increasing value rotates line clockwise
	 * */
	static public void line(Point point, Dimensions dimensions) {
		int length = dimensions.width();
		float angle = dimensions.dims[1];
		parent.line(point.x(), 
					point.y(), 
					point.x() + length * (float)Math.cos(PApplet.radians(angle)), 
					point.y() + length * (float)Math.sin(PApplet.radians(angle)));
	}
	
	static public void text(String s, Point p) {
		if(p != null) {
			text(s, p.x, p.y);
		} else {
			new Print("text point was null, drawing at 0,0 instead", Logging.DEBUG);
			text(s, 0, 0);
		}
	}
	
	static public void fill(Color color) {
		if(color != null) {
			parent.fill(color.r(),color.g(),color.b());
		} else {
			parent.noFill();
		}
	}
	
	static public void fill(float r, float g, float b) {
		parent.fill(r, g, b);
	}
	
	static public void fill(Integer color) {
		if(color != null) {
			parent.fill(limit(color, 0, 255));
		}
	}
	
	static public void stroke(Color color) {
		if(color != null) {
			parent.stroke(color.r(),color.g(),color.b());
		} else {
			parent.noStroke();
		}
	}
	
	static public void stroke(Integer color) {
		if(color != null) {
			if(color >= 0) {
				parent.stroke(limit(color, 0, 255));
			} else {
				parent.noStroke();
			}
		}
	}
	
	static public void textSize(Integer size) {
		if(size != null) {
			if(size >= 0) {
				parent.textSize(size);
			} else {
				new Print("text size must be positive!", Logging.WARNING);
			}
		}
	}
	
	static public void textAlign(Integer align) {
		if(align != null) {
			if(align >= 0) {
				parent.textAlign(align);
			} else {
				new Print("text align must be positive!", Logging.WARNING);
			}
		}
	}
	
	static public void rectMode(Integer mode) {
		if(mode != null) {
			if(mode >= 0) {
				parent.rectMode(mode);
			} else {
				new Print("rectmode must be positive!", Logging.WARNING);
			}
		}
	}
	
	static public void ellipseMode(Integer mode) {
		if(mode != null) {
			if(mode >= 0) {
				parent.ellipseMode(mode);
			} else {
				new Print("ellipseMode must be positive!", Logging.WARNING);
			}
		}
	}
	
	static public void pull(String direction) {
		if(direction != null) {
			switch(direction) {
			case "left":		pullLeft(); 					break;
			case "right":		pullRight(); 					break;
			case "up":			pullUp(); 						break;
			case "down":		pullDown(); 					break;
			case "up left":		pullUp();		pullLeft(); 	break;
			case "up right":	pullUp();		pullRight();	break;
			case "down left":	pullDown();		pullLeft(); 	break;
			case "down right":	pullDown();		pullRight(); 	break;
			case "left up":		pullLeft();		pullUp(); 		break;
			case "left down":	pullLeft();		pullDown(); 	break;
			case "right up":	pullRight();	pullUp(); 		break;
			case "right down":	pullRight();	pullDown(); 	break;
			}
		}
	}
	
	/*
	 * Pulls widget to the left by adjusting its point to as far left as it can
	 * 
	 *@return 1 if successful, 2 if overflow
	 * */
	//TODO: check for vertical fitting also (horizontal check implemented already below)
	/*
	static public int pullLeft() {
		float widthRemaining = App.width() - PIXELS_PULLED_LEFT_TOP.x() - PIXELS_PULLED_RIGHT_BOTTOM.x(); 
		if(widget.width() <= widthRemaining) {				//checks if the widget fits in remaining space
			widget.point.setX(PIXELS_PULLED_LEFT_TOP.x());	//sets point to its appropriate place
			PIXELS_PULLED_LEFT_TOP.add(widget.width(), 0);	//'consumes' that much space
		} else {											//if widget didnt fit
			widget.point().setY(widget.y() + widget.height()); //move to the next row
			if(widget.y() > App.height()) {					//check if widget is still onscreen
				return 2;
			} else
			return pullLeft(); 								//try again at the next row
		}
		return 1;											//was successful
	}
	*/
	
	//lazy skeleton
	static public int pullLeft() {
		widget.setX(0);	//sets point to its appropriate place
		return 1;
	}
	//lazy skeleton
	static public int pullRight() {
		widget.setX(App.width() - widget.width());	//sets point to its appropriate place
		return 1;
	}
	//lazy skeleton
	static public int pullUp() {
		widget.setY(0);	//sets point to its appropriate place
		return 1;
	}
	//lazy skeleton
	static public int pullDown() {
		widget.setY(App.height() - widget.height());	//sets point to its appropriate place
		return 1;
	}
	
	//TODO: pullRight, pullUp, pullDown, pullTopLeft, pullTopRight, pullBottomLeft, pullBottomRight
	
	static public void setWidget(Widget widg) {
		widget = widg;
	}
	
	static public void setShape(String s) {
		switch(s) {
		case "rectangle":
		case "ellipse":
		case "text":
		case "line":
			widgetShape = s;
			break;
		default:
			new Print("Attempted to set shape to unknown shape: " + s + ", instead defaulted to rectangle", Logging.DEBUG);
			widgetShape = "rectangle";
		}
	}
	
	static public void setStroke(Color c) {
		widgetStroke = c;
	}
	
	static public void setStrokeWeight(Integer weight) {
		widgetStrokeWeight = weight;
	}
	
	static public void setFill(Color c) {
		widgetFill = c;
	}
	
	static public void setTextColor(Color c) {
		widgetTextColor = c; 
	}
	
	static public void setDimensions(Dimensions dimensions) {
		widgetDimensions = dimensions;
	}
	
	static public void setRadius(Integer r) {
		widgetRadius = r;
	}
	
	static public void setRectMode(Integer i) {
		widgetRectMode = i;
	}
	
	static public void setTextSize(Integer i) {
		widgetTextSize = i;
	}
	
	static public void setTextAlign(Integer i) {
		widgetTextAlign = i;
	}
	
	static public void setEllipseMode(Integer i) {
		widgetEllipseMode = i;
	}
	
	static public void setPull(String direction) {
		switch(direction) {
		case "left":
		case "right":
		case "up":
		case "down":
		case "up left":
		case "up right":
		case "down left":
		case "down right":
		case "left up":
		case "left down":
		case "right up":
		case "right down":
			widgetPull = direction;
			break;
		default:
			widgetPull = "none";
			new Print("attempted to set widget pull to unknown direction " + direction + ", set to 'none' instead.", Logging.WARNING);
		}
		
	}
	
	static public PVector toPVector(Point point) {
		return new PVector(point.x(), point.y());
	}
	
	
	
/////////////////////////////////////////////////////////////////////////////////////////////////
/***********************************************************************************************/
/////////////////////////////////////////////////////////////////////////////////////////////////
	
	//INTERFACES
	public interface MouseActivities {
		
		boolean isTarget();

		void onMouseHover();

		void onMouseHoverOver();
		
		void onMouseClick();

		void onMousePress();

		void onMouseDrag(PVector mouse);

		void onMouseRelease();
		
	}
	
	
	public interface KeyboardActivities {
		
		void onKeyDown(char c);

		void onKeyHold(char c);

		void onKeyUp(char c);

		boolean isSelected();
		
	}
	
	/*
	 * Interface for things that want to be displayed that are not widgets (interactable).
	 * These implement their own display function external from the App shapes
	 * */
	public interface Display {
		
		public void display();
		
	}
	
	
	interface Listener {
		
		void listen();
		
	}
	
	
	interface Spacebar {
		
		void onSpacebar();
		
	}

	
	interface Enter {
		
		void onEnter();
		
	}

	
	interface Backspace {
		
		void onBackspace();
		
	}
	
	
	public interface Selectable {
		
		public void select();

		public void deselect();
		
	}
	
	
	
}




