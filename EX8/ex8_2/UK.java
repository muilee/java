package ex8_2;

enum UK {
	Buckingham, BritishMuseum;
	
	@Override
	public String toString() {
		String type = "";
		switch(this) {
			case Buckingham:
				type += "Buckingham";
				break;
			case BritishMuseum:
				type += "BritishMuseum";
				break;
		}
		return type;
	}
}
