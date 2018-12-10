package hailo;

import hailo.Attribute.EllipseMode;
import hailo.Attribute.Fill;
import hailo.Attribute.Pull;
import hailo.Attribute.Radius;
import hailo.Attribute.RectMode;
import hailo.Attribute.Shape;
import hailo.Attribute.Stroke;
import hailo.Attribute.StrokeWeight;
import hailo.Attribute.TextAlign;
import hailo.Attribute.TextColor;
import hailo.Attribute.TextSize;
import processing.core.PConstants;

public class Style implements PConstants {
	public String 					name 		= null;
	public Dimensions 				dimensions	= null;
	public Attribute.Stroke 		stroke		= null;
	public Attribute.StrokeWeight   strokeWeight= new StrokeWeight(1);
	public Attribute.Fill 			fill		= null;
	public Attribute.TextSize 		textSize	= null;
	public Attribute.TextAlign 		textAlign	= null;
	public Attribute.TextColor 		textColor	= null;
	public Attribute.RectMode 		rectMode	= null;
	public Attribute.EllipseMode 	ellipseMode	= null;
	public Attribute.Radius 		radius		= null;
	public Attribute.Shape 			shape		= null;
	public Attribute.Pull 			pull		= null;
	
	public Style(Style style) {
		this.name = style.name;
		this.dimensions = new Dimensions(style.dimensions());
		this.stroke = new Stroke(style.stroke());
		this.strokeWeight = new StrokeWeight(style.strokeWeight());
		this.fill = new Fill(style.fill());
		this.textSize = new TextSize(style.textSize());
		this.textAlign = new TextAlign(style.textAlign());
		this.textColor = new TextColor(style.textColor());
		this.rectMode = new RectMode(style.rectMode());
		this.ellipseMode = new EllipseMode(style.ellipseMode());
		this.radius = new Radius(style.radius());
		this.shape = new Shape(style.shape());
		this.pull = new Pull(style.pull());
	}
	
	public Style(String name) {
		this.name = name;
		App.putStyle(this.name,this);
	}
	
	public String toString() {
		return this.name;
	}
	
	
	public Style setString(String string) {
		name = string;
		return this;
	}
	public Style setDimensions(Dimensions dimensions) {
		this.dimensions.set(dimensions);
		return this;
	}
	public Style setStroke(Color color) {
		if(this.stroke != null) {
			this.stroke.set(color);
		} else {
			this.stroke = new Stroke(color); 
		}
		return this;
	}
	public Style setStrokeWeight(Integer weight) {
		if(this.strokeWeight != null) {
			this.strokeWeight.set(weight);
		} else {
			this.strokeWeight = new StrokeWeight(weight); 
		}
		return this;
	}
	public Style setFill(Color color) {
		if(this.fill != null) {
			this.fill.set(color);
		} else {
			this.fill = new Fill(color); 
		}
		return this;
	}
	public Style setTextSize(Integer size) {
		if(this.textSize != null) {
			this.textSize.set(size);
		} else {
			this.textSize = new TextSize(size); 
		}
		return this;
	}
	public Style setTextAlign(Integer align) {
		if(this.textAlign != null) {
			this.textAlign.set(align);
		} else {
			this.textAlign = new TextAlign(align); 
		}
		return this;
	}
	public Style setTextColor(Color color) {
		if(this.textColor != null) {
			this.textColor.set(color);
		} else {
			this.textColor = new TextColor(color); 
		}
		return this;
	}
	public Style setRectMode(Integer mode) {
		if(this.rectMode != null) {
			this.rectMode.set(mode);
		} else {
			this.rectMode = new RectMode(mode); 
		}
		return this;
	}
	public Style setEllipseMode(Integer mode) {
		if(this.ellipseMode != null) {
			this.ellipseMode.set(mode);
		} else {
			this.ellipseMode = new EllipseMode(mode); 
		}
		return this;
	}
	public Style setRadius(Integer radius) {
		if(this.radius != null) {
			this.radius.set(radius);
		} else {
			this.radius = new Radius(radius);
		}
		return this;
	}
	public Style setShape(String shape) {
		if(this.shape != null) {
			this.shape.set(shape);
		} else {
			this.shape = new Shape(shape);
		}
		return this;
	}
	
	
	public Dimensions dimensions() {
		return this.dimensions;
	}
	
	public Color stroke() {
		if(this.stroke != null) {
			return this.stroke.color();
		} else return null;
	}
	public Integer strokeWeight() {
		if(this.strokeWeight != null) {
			return this.strokeWeight.value();
		} else return null;
	}
	public Color fill() {
		if(this.fill != null) {
			return this.fill.color();
		} else return null;
	}
	public Color textColor() {
		if(this.textColor != null) {
			return this.textColor.color();
		} else return null;
	}
	public Integer textSize() {
		if(this.textSize != null) {
			return this.textSize.value();
		} else return null;
	}
	public Integer textAlign() {
		if(this.textAlign != null) {
			return this.textAlign.value();
		} else return null;
	}
	public Integer rectMode() {
		if(this.rectMode != null) {
			return this.rectMode.value();
		} else return null;
	}
	public Integer ellipseMode() {
		if(this.ellipseMode != null) {
			return this.ellipseMode.value();
		} else return null;
	}
	public Integer radius() {
		if(this.radius != null) {
			return this.radius.value();
		} else return null;
	}
	
	public String shape() {
		if(this.shape != null) {
			return this.shape.string();
		} else return null;
	}
	public String pull() {
		if(this.pull != null) {
			return this.pull.string();
		} else return null;
	}
}
