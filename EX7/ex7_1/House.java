package ex7_1;

class House extends Cube{
	private String material;
	House(double length, double width, double height, String material){
		super(length, width, height);
		this.material = material;
	}
	public String getMaterial() {
		return material;
	}
	
	public void setMaterial(String material) {
		this.material = material;
	}
	
	@Override
	String getInfo() {
		String s = super.getInfo();
		s += "; §÷½è = " + this.material;
		return s;
	}
}