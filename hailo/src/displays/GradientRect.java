package displays;

import hailo.App;
import hailo.App.Display;
import processing.core.PConstants;

/***********************************************************************************************/
public class GradientRect implements Display {
	char r_start, g_start, b_start, r_end, g_end, b_end;
	/*
	 * GradientRect is a screen-sized top-down gradient.
	 * Enter start and ending color in RGB format
	 * */
	public GradientRect(char r_start, 
						char g_start, 
						char b_start, 
						char r_end, 
						char g_end, 
						char b_end) 
	{
		this.r_start = r_start;
		this.g_start = g_start;
		this.b_start = b_start;
		this.r_end = r_end;
		this.g_end = g_end;
		this.b_end = b_end;
	}
	
	/*
	 * GradientRect is a screen-sized top-down gradient.
	 * Enter start and ending color in RGB format
	 * */
	public GradientRect(int r_start, 
						int g_start, 
						int b_start, 
						int r_end, 
						int g_end, 
						int b_end) 
	{
		this((char) r_start, 
			(char) g_start, 
			(char) b_start, 
			(char) r_end, 
			(char) g_end, 
			(char) b_end);
	}
	
	public void display() {
		char lines = 100;
		App.stroke(-1);
		App.rectMode(PConstants.CORNER);
		for(char i = 0; i < lines; i++) {
			App.fill(r_start + (r_end - r_start) / (float)lines *  i, 
					g_start + (g_end - g_start) / (float)lines *  i, 
					b_start + (b_end - b_start) / (float)lines *  i);
			App.rect(0, App.height() / lines * i, App.width(), App.height() / lines * (i + 1));
		}
	}
}