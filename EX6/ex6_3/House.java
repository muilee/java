package ex6_3;

class House extends Cube{
	String material;
	House(double length, double width, double height, String material){
		super(length, width, height);
		this.material = material;
	}
	
	String getInfo() {
		String s = super.getInfo();
		s += "; §÷½è = " + this.material;
		return s;
	}
}