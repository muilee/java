package ex8_2;

enum Taiwan {
	Cihu, Yushan;
	
	@Override
	public String toString() {
		String type = "";
		switch(this) {
			case Cihu:
				type += "Cihu";
				break;
			case Yushan:
				type += "Yushan";
				break;
		}
		return type;
	}
}
