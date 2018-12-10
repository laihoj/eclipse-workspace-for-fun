package SleekUtils;
import java.util.HashSet;

import commands.Print;
import hailo.AbstractCommand;
import hailo.App;
import hailo.Command;
import hailo.Dimensions;
import hailo.EllipseWidget;
import hailo.Logging;
import hailo.Point;
import hailo.Widget;
import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PVector;
import widgets.Label;

public class Node extends Widget {
	Physics physics;
	Label label;
	HashSet<Node> nodes = new HashSet<Node>();
	public Node(Point point, String name, String className) {
		super(point, name, className);
		this.label = new Label(point, name, "NodeLabelStyle"); 
		this.add(label);
		this.physics = new Physics(this).setFriction((float) 0.1);
	}
	
	public HashSet<Node> nodes() {
		return this.nodes;
	}
	
	public void add(Node node) {
		boolean exists = false;
		for(Node n: this.nodes) {
			if(n.name() == node.name())
				exists = true;
		}
		if(!exists) {
			this.nodes.add(node);
			this.add((Widget) node);
		}
	}
	public boolean isTarget() {
		int r = this.dimensions().radius();
		return App.isTargetEllipse(new Point(this.point().x() - r, this.point().y()-r), this.dimensions());
	}
	
	public void setPosition(Point point) {
		this.setPoint(point);
		this.label.setPoint(point);
		App.redraw();
	}
	
	public void push(PVector force) {
		physics.addForce(force);
	}
	
	public boolean collideWith(Widget that) {
		return this.physics.collidingWith(that);
	}
	
	public void display() {
		super.display();
		for(Node child: nodes) {
			float direction = PApplet.degrees(App.direction(child.point(), this.point()));
			float r = (float) child.point().dist(this.point());
			float radius = this.dimensions().radius();
			int length = (int)(r - radius - child.dimensions().radius());
			if(length > 0) {
				App.line(new Point(this.point()).add(
						new Point(
								(float)Math.cos(PApplet.radians(direction)) * radius,
								(float)Math.sin(PApplet.radians(direction)) * radius)), 
						new Dimensions((int) (length), 
								(int) (direction)));
			}
		}
	}
	
	//returns the force that the two nodes must push each other with
	public PVector collision(Node one, Node two) {
		float dx = one.x() - two.x();
        float dy = one.y() - two.y();
	    float minDist = one.width() / 2 + two.width() / 2;
		float angle = (float) Math.atan2(dy, dx);
        float targetX = (float) (two.x() + Math.cos(angle) * minDist);
        float targetY = (float) (two.y() + Math.sin(angle) * minDist);
        float ax = (float) ((targetX - one.x()) * 0.05);
        float ay = (float) ((targetY - one.y()) * 0.05);
        return new PVector(ax,ay);
	}
	public void compute() {
		super.compute();
		if(App.offScreen(this)) {
			setPosition(new Point(App.width() / 2, App.height() / 4));
		}
		this.physics.apply();
		for(Node child: nodes) {
			child.compute();
			if(this.collideWith(child)) {
				child.push(collision(child, this));
		        App.redraw();
			}
			for(Node child2: nodes) {
				if(child2.collideWith(child)) {
					PVector force = collision(child, child2); 
					child.push(force);
					child2.push(force.rotate(PConstants.PI));
					App.redraw();
				}
			}
		}
	}
}
