package ex8_2;

enum Country {
	US, UK, TAIWAN;
	
	@Override
	public String toString() {
		String type = "";
		switch(this) {
			case US:
				type += "US";
				break;
			case UK:
				type += "UK";
				break;
			case TAIWAN:
				type += "TAIWAN";
				break;
		}
		return type;
	}
}
