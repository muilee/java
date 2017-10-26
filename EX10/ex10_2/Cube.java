package ex10_2;

import java.io.*;

public class Cube implements Serializable{
	double length, width, height;
	public Cube(double length, double width, double height) {
		this.length = length;
		this.width = width;
		this.height = height;
	}
	
	@Override
	public String toString() {
		String text = String.format("ªø = %.1f; ¼e  = %.1f; ªø = %.1f; Åé¿n = %.1f", 
				this.length, this.width, this.height,
				this.length * this.width * this.height);
		return text;
	}
}
