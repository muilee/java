package ex8_2;

enum US {
	GrandCanyon, Yellowstone;
	
	@Override
	public String toString() {
		String type = "";
		switch(this) {
			case GrandCanyon:
				type += "GrandCanyon";
				break;
			case Yellowstone:
				type += "Yellowstone";
				break;
		}
		return type;
	}
}
