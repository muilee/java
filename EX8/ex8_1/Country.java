package ex8_1;

enum Country {
	US, UK, TAIWAN, JAPAN;
	
	@Override
	public String toString() {
		String type = "";
		switch(this) {
			case US:
				type += "US(美國)";
				break;
			case UK:
				type += "UK(英國)";
				break;
			case TAIWAN:
				type += "TAIWAN(台灣)";
				break;
			case JAPAN:
				type += "JAPAN(日本)";
				break;
		}
		return type;
	}
	public String getInfo() {
		String info = "";
		switch(this) {
			case US:
				info += "美式烤火雞十分多汁可口";
				break;
			case UK:
				info += "英式下午茶十分悠閒愉快";
				break;
			case TAIWAN:
				info += "台灣小吃經濟實惠又美味";
				break;
			case JAPAN:
				info += "日式料理十分多樣且豐富";
				break;
		}
		return info;
	}
}
