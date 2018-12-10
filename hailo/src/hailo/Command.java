package hailo;


//this class is useful for implementing a FIFO stack in the main app.
//abstract command implements this interface, implementing the method queue
//queue is always the same: add this command to the stack
public interface Command {
	
	//Do something
	void execute();

	//add this to the command stack
	void queue();
	
	//reverse what is done by execute
	void undo();

}