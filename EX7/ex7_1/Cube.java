package ex7_1;

public class Cube {
	private double length, width, height;
	Cube(double length, double width, double height){
		this.length = length;
		this.width = width;
		this.height = height;
	}
	
	double volumn() {
		return this.length * this.width * this.height;
	}
	
	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	String getInfo() {
		return "ªø = " + this.length + "; ¼e = " + this.width + 
				"; °ª  = " + this.height + "; Åé¿n = " + this.volumn();
	}
}

