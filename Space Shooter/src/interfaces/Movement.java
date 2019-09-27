package interfaces;

import processing.core.PVector;

public interface Movement {
	public PVector LEFTWARDS = new PVector((float) -0.35,0);
	public PVector RIGHTWARDS = new PVector((float) 0.35,0);
	public PVector UPWARDS = new PVector(0,(float) -0.35);
	public PVector DOWNWARDS = new PVector(0, (float) 0.35);
}
