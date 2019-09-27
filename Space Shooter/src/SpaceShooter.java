import processing.core.PApplet;
import widgets.Label;
import widgets.Navigation_Button;
import hailo.*;
import displays.GradientRect;
import environments.Map1;
import environments.Map2;
import environments.Map3;
import gameObjects.GameView;

public class SpaceShooter extends PApplet {
	public static void main(String[] args) {
		PApplet.main("SpaceShooter");
	}

	public void settings() {
		/*
		 * set size of screen to Samsung Galaxy S7 Edge size. 
		 * (Discovered by trial and error)
		 * (Alternatively use fullScreen()?)
		 * */
		size(1440/4,2560/4);
	}

	public void setup() {
		/*
		 * Framerate is defined in setup, not settings (Try to just remember this)
		 * */
		frameRate(60);
		
		/*
		 * And the developer said, let there be an app!
		 * (in debugging mode)
		 * */
		new App(this, Logging.DEBUG);
		
		/*
		 * And the developer imported the style classes he had written 
		 * (located in the styles folder),
		 * and declared with what name the objects shall access them by.
		 * (do this after initialising the app)
		 * */
		new styles.Player("Player");
		new styles.Player.Hovering("PlayerHovering");
		new styles.Ship1("Ship1");
		new styles.Turret("Turret");
		new styles.Pursuant("Pursuant");
		new styles.ShootyFollowy("ShootyFollowy");
		new styles.Projectile("Projectile");
		new styles.CannonBall("CannonBall");
		//overrides normal button
		new styles.Button1("Button");
		
		/*
		 * An app can have multiple views.
		 * Here is the main menu view!
		 * */
		View MAIN_MENU = new View(new Point(), "Main menu", "Container");
		MAIN_MENU.add(new GradientRect(0,0,0,120,120,120));
		
		/*
		 * Let's add a label (text box) to the main menu.
		 * */
		Label title = new Label(new Point(App.width() / 2, App.height() / 2), "Basic space shooter", "Label");
		MAIN_MENU.add(title);
		
		/*
		 * Here is another view, the playing view!
		 * Notice how you can give your view whatever name you choose! 
		 * (mostly it makes no difference)
		 * */
		GameView GAME_OVER = new GameView(new Point(), "Game over", "");
		GAME_OVER.add(new GradientRect(0,0,0,120,0,0));
		
		GAME_OVER.add(new Label(new Point(App.width() / 2, App.height() /2), "Game over", "Label"));
		
		GAME_OVER.add(new Navigation_Button(new Point(App.width() / 2, App.height() / 5), "Main menu", "Button", MAIN_MENU));
		
		
		/*
		 * Generally widgets are created with three parameters; point, name, and style. 
		 * Some widgets have an additional parameter (buttons can have their action as a fourth parameter
		 * Some widgets have fewer parameters.
		 * 
		 * Generally: [VIEW].add(new [WIDGET_CLASS](new Point([X], [Y]), "[NAME]", "[STYLE]"))
		 * */
		 
		MAIN_MENU.add(new Navigation_Button(new Point(0,0), 	"map1", "Button", new Map1(GAME_OVER)));
		
		MAIN_MENU.add(new Navigation_Button(new Point(100,100), "map2", "Button", new Map2(GAME_OVER)));
		
		MAIN_MENU.add(new Navigation_Button(new Point(200,200), "map3", "Button", new Map3(GAME_OVER)));
		
	}
	
	/*
	 * This function stub must be stated, otherwise the app runs only the first frame.
	 * Essentially, it makes sure the app keeps on looping (drawing?) infinitely
	 * */
	public void draw() {}	
}