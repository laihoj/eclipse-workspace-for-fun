package hailo;

import processing.core.PVector;

/***********************************************************************************************/
public class Point {
	protected float x, y;

	
	/*
	 * Constructors
	 * */
	
	public Point(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public Point(PVector point) {
		this(point.x, point.y);
	}
	
	public Point(Point point) {
		this(point.x(), point.y());
	}

	public Point(int x, int y) {
		this((float) x, (float) y);
	}

	public Point() {
		this(0, 0);
	}
	
	/*
	 * Getters
	 * */
	
	
	public float x() {
		return this.x;
	}
	
	public float y() {
		return this.y;
	}
	
	/*
	 * Setters
	 * */
	
	public Point setX(float x) {
		this.x = x;
		return this;
	}
	public Point setY(float y) {
		this.y = y;
		return this;
	}
	
	/*
	 * Methods
	 * */

	public Point add(float x, float y) {
		setX(this.x() + x);
		setY(this.y() + y);
		return this;
	}
	
	public Point add(Point that) {
		add(that.x(), that.y());
		return this;
	}

	public Point add(PVector that) {
		add(that.x, that.y);
		return this;
	}

	public Point sub(float x, float y) {
		setX(this.x() - x);
		setY(this.y() - y);
		return this;
	}
	
	public Point sub(Point that) {
		sub(that.x(), that.y());
		return this;
	}

	public Point sub(PVector that) {
		sub(that.x, that.y);
		return this;
	}

	/*
	 * Maths
	 * */
	
	public double dist(Point that) {
		return Math.sqrt((float) (Math.pow((that.x - this.x), 2) + Math.pow((that.y - this.y), 2)));
	}

	public double dist(PVector that) {
		return Math.sqrt((float) (Math.pow((that.x - this.x), 2) + Math.pow((that.y - this.y), 2)));
	}

	public float heading(Point that) {
		return new PVector(this.x - that.x, this.y - that.y).heading();
	}

	public PVector toPVector() {
		return new PVector(this.x, this.y);
	}
}

/***********************************************************************************************/