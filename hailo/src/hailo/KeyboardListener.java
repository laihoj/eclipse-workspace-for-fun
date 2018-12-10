package hailo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import processing.core.PConstants;

public class KeyboardListener extends EventListener {
	boolean wasKeyPressed = false;
	HashMap<Character, Boolean> keys = new HashMap<Character, Boolean>();
	ArrayList<Character> keysPressed;
	ArrayList<Character> keysReleased;
	String alphabet;
	
	public KeyboardListener() {
		this.alphabet = "";
		//Adds basic characters to the alphabet string
		for (int i = 32; i < 127; i++) {
			this.alphabet += (char) i;
		}
		// this.alphabet = "1234567890 abcdefghijklmnopqrstuvwxyz";
		//adds fancy keys to the alphabet string
		this.alphabet += PConstants.BACKSPACE;
		this.alphabet += PConstants.DELETE;
		this.alphabet += PConstants.ENTER;
		this.alphabet += PConstants.RETURN;
		this.alphabet += PConstants.TAB;
		this.alphabet += PConstants.ESC;
		this.alphabet += PConstants.DOWN;
		this.alphabet += PConstants.UP;
		this.alphabet += PConstants.RIGHT;
		this.alphabet += PConstants.LEFT;
		keysPressed = new ArrayList<Character>();
		keysReleased = new ArrayList<Character>();
	}
	
	public void display() {
		String res = "\nkeys";
		for (char c : keys.keySet()) {
			res += "\n" + c + ": " + keys.get(c);
		}
		App.parent.stroke(0);
		App.parent.fill(0);
	
		String res2 = "\nkeysPressed";
		for (char c : keysPressed) {
			res2 += "\n" + c;
		}
	
		String res3 = "\nkeysReleased";
		for (char c : keysReleased) {
			res3 += "\n" + c;
		}
	
		App.parent.text(res, 0, 0);
		App.parent.text(res2, 100, 0);
		App.parent.text(res3, 200, 0);
	
	}
	
	public String toString() {
		String res = "\nkeys";
		for (char c : keys.keySet()) {
			res += "\n" + c + ": " + keys.get(c);
		}
		App.parent.stroke(0);
		App.parent.fill(0);
	
		String res2 = "\nkeysPressed";
		for (char c : keysPressed) {
			res2 += "\n" + c;
		}
	
		String res3 = "\nkeysReleased";
		for (char c : keysReleased) {
			res3 += "\n" + c;
		}
		return res + "\n" + res2 + "\n" + res3;
	}
	
	public void add(char[] cs) {
		for (char c : cs) {
			this.keys.put(c, false);
		}
	}
	
	public void add(char c) {
		this.keys.put(c, false);
	}
	
	public Set<Character> getKeys() {
		return this.keys.keySet();
	}
	
	public void clearKeyMap() {
		for (char c : alphabet.toCharArray()) {
			this.keys.put(c, false);
		}
	}
	
	public void listen() {
		// Figure out which keys are (newly) pressed or released
		
		for (char c : this.keysPressed) {
			for (Observer observer : this.observers) {
				observer.pressKey(c);
			}
		}
		this.keysPressed.clear();
		for (char c : this.keysReleased) {
			for (Observer observer : this.observers) {
				observer.releaseKey(c);
			}
		}
		this.keysReleased.clear();
		for (char c : this.keys.keySet()) {
			for (Observer observer : this.observers) {
				if (keys.get(c)) {
					observer.holdKey(c);
				}
			}
		}
		//if nothing is pressed, set all keys to false;
		if (!App.keyPressed) {
			clearKeyMap();
		}
	}
}