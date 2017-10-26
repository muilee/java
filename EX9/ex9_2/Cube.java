package ex9_2;

public class Cube{
	private double length;
	public Cube() {
		
	}
	public double getLength() {
		return length;
	}
	public void setLength(double length) throws CubeException{
		if(length <= 0) {
			throw new CubeException("length can't equal or be less than 0");
		}else {
			this.length = length;
		}
		
	}
	
}
	
