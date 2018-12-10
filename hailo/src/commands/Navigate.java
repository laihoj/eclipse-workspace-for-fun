package commands;

import hailo.App;
import hailo.View;


public class Navigate extends ChangeView {
	View previous = null;
	
	public Navigate(View next) {
		super(next);
	}
	
	public void execute() {
		//Sequence is important, super.execute changes active view to next
		this.previous = App.active_view;
		super.execute();
		App.navigationHistory.add(this);
	}
	
	public void undo() {
		super.undo();
		System.out.println("Returning from " + App.active_view.toString() + " to " + this.target);
		//previous is initialised as null, hope the user executes before undoing
		App.activate(previous);
	}
}