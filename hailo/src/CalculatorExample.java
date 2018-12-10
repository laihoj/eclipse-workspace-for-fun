import processing.core.PApplet;
import widgets.Button;
import widgets.Label;
import hailo.*;


public class CalculatorExample extends PApplet {
	public static void main(String[] args) {
		PApplet.main("CalculatorExample");
	}

	
	Label calculation;
	Label prevResult;
	
	public void settings() {
		/*
		 * set size of screen to Samsung Galaxy S7 Edge size.
		 * size(1440/4,2560/4); 
		 * (Alternatively use fullScreen())
		 * */
		size(360,640);
	}

	public void setup() {
		/*
		 * Framerate is defined in setup, not settings (Try to just remember this)
		 * */
		frameRate(60);
		
		/*
		 * And the developer said, let there be an app!
		 * (In debugging mode, that is)
		 * */
		new App(this, Logging.DEBUG);
		
		new Key("Button");
		new KeyPressedStyle("ButtonPressed");
		new KeyHoveringStyle("ButtonHovering");
		new EqualsKey("EqualsButton");
		new EqualsKeyHovering("EqualsButtonHovering");
		new EqualsKeyPressed("EqualsButtonPressed");
		
		/*
		 * An app can have multiple views.
		 * Here is the main menu view!
		 * */
		View MAIN_MENU = new View(new Point(), "Main menu", "View");
		
		
		
		/*
		 * Let's add a label (text box) to the main menu.
		 * */
		calculation = new Label(new Point(App.width() * 3 / 4, 55), "0", "Label");
		MAIN_MENU.add(calculation);
		MAIN_MENU.add(new Label(new Point(App.width() * 3 / 4, 15), "Calculation", "Label"));
		
		prevResult = new Label(new Point(App.width() * 1 / 4, 55), "0", "Label");
		MAIN_MENU.add(prevResult);
		MAIN_MENU.add(new Label(new Point(App.width() * 1 / 4, 15), "Result", "Label"));
		
		
		MAIN_MENU.add(new Button(new Point(0 * App.width() / 4, App.height() - 5 * App.width() / 4), "C", "Button", new Reset()));
		MAIN_MENU.add(new Button(new Point(0 * App.width() / 4, App.height() - 4 * App.width() / 4), "7", "Button", new NumberPressed(7)));
		MAIN_MENU.add(new Button(new Point(0 * App.width() / 4, App.height() - 3 * App.width() / 4), "4", "Button", new NumberPressed(4)));
		MAIN_MENU.add(new Button(new Point(0 * App.width() / 4, App.height() - 2 * App.width() / 4), "1", "Button", new NumberPressed(1)));
		MAIN_MENU.add(new Button(new Point(0 * App.width() / 4, App.height() - 1 * App.width() / 4), "+/-", "Button"));
		
		MAIN_MENU.add(new Button(new Point(1 * App.width() / 4, App.height() - 5 * App.width() / 4), "D", "Button", new Delete()));
		MAIN_MENU.add(new Button(new Point(1 * App.width() / 4, App.height() - 4 * App.width() / 4), "8", "Button", new NumberPressed(8)));
		MAIN_MENU.add(new Button(new Point(1 * App.width() / 4, App.height() - 3 * App.width() / 4), "5", "Button", new NumberPressed(5)));
		MAIN_MENU.add(new Button(new Point(1 * App.width() / 4, App.height() - 2 * App.width() / 4), "2", "Button", new NumberPressed(2)));
		MAIN_MENU.add(new Button(new Point(1 * App.width() / 4, App.height() - 1 * App.width() / 4), "0", "Button", new NumberPressed(0)));
		
		MAIN_MENU.add(new Button(new Point(2 * App.width() / 4, App.height() - 5 * App.width() / 4), "( )", "Button"));
		MAIN_MENU.add(new Button(new Point(2 * App.width() / 4, App.height() - 4 * App.width() / 4), "9", "Button", new NumberPressed(9)));
		MAIN_MENU.add(new Button(new Point(2 * App.width() / 4, App.height() - 3 * App.width() / 4), "6", "Button", new NumberPressed(6)));
		MAIN_MENU.add(new Button(new Point(2 * App.width() / 4, App.height() - 2 * App.width() / 4), "3", "Button", new NumberPressed(3)));
		MAIN_MENU.add(new Button(new Point(2 * App.width() / 4, App.height() - 1 * App.width() / 4), ".", "Button", new Comma()));
		
		MAIN_MENU.add(new Button(new Point(3 * App.width() / 4, App.height() - 5 * App.width() / 4), "/", "Button", new KeyPressed('/')));
		MAIN_MENU.add(new Button(new Point(3 * App.width() / 4, App.height() - 4 * App.width() / 4), "x", "Button", new KeyPressed('x')));
		MAIN_MENU.add(new Button(new Point(3 * App.width() / 4, App.height() - 3 * App.width() / 4), "-", "Button", new KeyPressed('-')));
		MAIN_MENU.add(new Button(new Point(3 * App.width() / 4, App.height() - 2 * App.width() / 4), "+", "Button", new KeyPressed('+')));
		MAIN_MENU.add(new Button(new Point(3 * App.width() / 4, App.height() - 1 * App.width() / 4), "=", "EqualsButton", new Calculate()));
		
	}
	
	public class Delete extends AbstractCommand {
		Delete() {}
		public void execute() {
			String name = calculation.name();
			if(name.length() > 1 ) {
				calculation.setName(calculation.name().substring(0, calculation.name().length() - 1));
			} else {
				calculation.setName("0");
			}
		}
	}
	
	public class Reset extends AbstractCommand {
		Reset() {}
		public void execute() {
			prevResult.setName("0");
			calculation.setName("0");
		}
	}
	
	
	public class Calculate extends AbstractCommand {
		Calculate() {}
		public void execute() {
			prevResult.setName(calculation.name());
			calculation.setName("0");
		}
	}
	
	public class Comma extends AbstractCommand {
		Comma() {}
		public void execute() {
			if(!calculation.name().contains(".")) {
				new KeyPressed('.').execute();
			}
		}
	}
	
	public class NumberPressed extends AbstractCommand {
		int number;
		NumberPressed(int n) {
			this.number = n;
		}
		public void execute() {
			if(calculation.name().equals("0")) {
				calculation.setName(""+this.number);
			} else {
				calculation.setName(calculation.name() + this.number);
			}
		}
	}
	
	public class KeyPressed extends AbstractCommand {
		char character;
		KeyPressed(char c) {
			this.character = c;
		}
		public void execute() {
			String current = calculation.name();
			char lastChar = current.charAt(current.length() - 1); 
			if(lastChar >= '0' && lastChar <= '9') {
				calculation.setName(calculation.name() + this.character);
			} else {
				calculation.setName(current.substring(0,current.length() - 1) + character);
			}
		}
	}
	
	public class Key extends styles.Button {
		Key(String name) {
			super(name);
			setDimensions(new Dimensions(min(App.width(), App.height()) / 4, min(App.width(), App.height()) / 4));
			setFill(new Color(255, 255, 255));
			setStroke(new Color(125, 125, 125));
		}
	}
	public class KeyPressedStyle extends Key {
		KeyPressedStyle(String name) {
			super(name);
			setFill(new Color(50, 50, 100));
		}
	}
	public class KeyHoveringStyle extends Key {
		KeyHoveringStyle(String name) {
			super(name);
			setFill(new Color(0, 200, 180));
		}
	}
	
	public class EqualsKey extends Key {
		EqualsKey(String name) {
			super(name);
			setFill(new Color(0, 132, 180));
		}
	}
	public class EqualsKeyHovering extends Key {
		EqualsKeyHovering(String name) {
			super(name);
			setFill(new Color(0, 200, 180));
		}
	}
	public class EqualsKeyPressed extends Key {
		EqualsKeyPressed(String name) {
			super(name);
			setFill(new Color(50, 50, 100));
		}
	}
	public void draw() {}
}