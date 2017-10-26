package ex6_3;

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
		return "ªø = " + this.length + "; ¼e = " + this.width + 
				"; °ª  = " + this.height + "; Åé¿n = " + this.volumn();
	}
}

