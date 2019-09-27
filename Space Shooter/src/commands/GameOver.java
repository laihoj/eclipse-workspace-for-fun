package commands;

import hailo.AbstractCommand;
import hailo.App;
import hailo.Logging;
import hailo.View;

public class GameOver extends AbstractCommand {
	View gameOverView;
	public GameOver(View gameOverView) {
		this.gameOverView = gameOverView;
	}
	public void execute() {
		App.activate(gameOverView);
		new Print("Game over!", Logging.WARNING);
	}
}
