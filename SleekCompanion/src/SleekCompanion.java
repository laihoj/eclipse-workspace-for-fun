import processing.core.PApplet;
import widgets.Button;
import widgets.Label;
import widgets.Navigation_Button;
import widgets.StateBox;
import SleekUtils.NavButtonStyle;
import SleekUtils.NewNode;
import SleekUtils.Node;
import SleekUtils.NodeCollectionLabelStyle;
import SleekUtils.NodeCollectionStyle;
import SleekUtils.NodeLabelStyle;
import SleekUtils.NodeStyle;
import SleekUtils.TransmittingBoxStyle;
import SleekUtils.TransmittingStateBox;
import commands.DoNothing;
import commands.Print;
import hailo.*;
import hailo.Attribute.Fill;


public class SleekCompanion extends PApplet {
	public static void main(String[] args) {
		PApplet.main("SleekCompanion");
	}

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
		new App(this, Logging.WARNING);
		
//		final String url = "https://sleekgestures.herokuapp.com/";
//		Database db = new Database(url);

//		try {
//			String response = db.getDevicesByUser("jaakko");
//			println(response);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		/*
		 * importing styles
		 * */
		new styles.Container("View");
		new NodeStyle("NodeStyle");
		new NodeLabelStyle("NodeLabelStyle");
		new NodeCollectionStyle("NodeCollectionStyle");
		new NodeCollectionLabelStyle("NodeCollectionLabelStyle");
		new NavButtonStyle("NavButtonStyle")
			.new NavButtonStyleHovering("NavButtonStyleHovering")
			.new NavButtonStylePressed("NavButtonStylePressed");
		new TransmittingBoxStyle("StateBox")
			.new Hovering()
			.new Pressed()
			.new On();
		
		int buttonWidth = App.width() / 3;	//lousy not DRY. Go to NavButtonStyle
		int buttonHeight = App.height() / 20; //lousy not DRY
		
		
		View MAIN_MENU = new View(new Point(), "Main menu", "View");
		View SETTINGS_MENU = new View(new Point(), "Settings Menu", "View");
		
//		MAIN_MENU.add(new Navigation_Button(new Point(5,5), "Settings", "NavButtonStyle", SETTINGS_MENU));
		
		
		SETTINGS_MENU.add(new Navigation_Button(new Point(App.width() - buttonWidth - 5, 5), "Nodes", "NavButtonStyle", MAIN_MENU));
		SETTINGS_MENU.add(
				new Button(
						new Point(App.width() / 2 - buttonWidth/2, App.height() / 2 - buttonHeight/2), 
						"Connect", 
						"NavButtonStyle",
						new DoNothing()));
		
		Node nodeBase = new Node(new Point(App.width() / 2, App.height() / 2), "Click\nTo Add\nNode", "NodeCollectionStyle");
		MAIN_MENU.add(nodeBase.setOnEvent("onMouseClick", new NewNode(nodeBase, "NODE")));
		
		String[] styles = {"On"};
		MAIN_MENU.add(new TransmittingStateBox(new Point(5, 5), "Track Motion", styles));
		
		
	}
	
	/*
	 * This function stub must be stated, otherwise the app runs only the first frame.
	 * Essentially, it makes sure the app keeps on looping (drawing?) infinitely
	 * */
	public void draw() {}
	
	
	
	
	
}