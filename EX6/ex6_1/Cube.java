package ex6_1;

public class Cube {
	double length, width, height;
	Cube(double length, double width, double height){
		this.length = length;
		this.width = width;
		this.height = height;
	}
	
	double volumn() {
		return this.length * this.width * this.height;
	}
	
	String getInfo() {
		return "�� = " + this.length + "\n�e = " + this.width + 
				"\n��  = " + this.height + "\n��n = " + this.volumn();
	}
}

