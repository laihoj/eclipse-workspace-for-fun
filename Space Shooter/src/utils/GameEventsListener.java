package utils;

import java.util.ArrayList;

import hailo.App;
import hailo.Command;
import hailo.EventListener;
import hailo.Logging;
import hailo.Observer;
import hailo.Widget;
import commands.Print;

public class GameEventsListener extends EventListener {
	public ArrayList<AbstractGameWidget> gameObservers = new ArrayList<AbstractGameWidget>();
	public GameEventsListener() {
	}
	
	public void addGameWidget(AbstractGameWidget child) {
		new Print(child.name() + " added via GameEventsListener", Logging.LOGGING);
		this.gameObservers.add(child);
	}
	public void removeGameWidget(AbstractGameWidget child) {
		new Print(child.name() + " removed via GameEventsListener", Logging.LOGGING);
		this.gameObservers.remove(child);
	}
	public void listen() {
		
		//offscreening
		for(AbstractGameWidget obs: this.gameObservers) {
			if(App.offScreen(obs)) {
				new Print(obs.name() + " am offscreen! better act accordingly", Logging.DEBUG);
				Command onOffScreen = obs.event("onOffScreen"); 
				if(onOffScreen != null) {
					obs.event("onOffScreen").queue();
				} else {
					new Print("No onOffScreen defined", Logging.WARNING);
				}
			}
		}
		
		//collision
		ArrayList<AbstractGameWidget> obs = this.gameObservers;
		int size = obs.size();
		new Print("So many objects to collide with: " + size, Logging.LOGGING);
		if(size > 1) {
			for(int i = 0; i < size; i++) {
				for(int j = i + 1; j < size; j++) {
					AbstractGameWidget This = obs.get(j);
					AbstractGameWidget That = obs.get(i);
					if(This.collideWith(That)) {
						This.collide();
						That.collide();
					}
				}
			}
		}
	}
}
