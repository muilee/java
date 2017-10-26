package ex8_1;

enum Country {
	US, UK, TAIWAN, JAPAN;
	
	@Override
	public String toString() {
		String type = "";
		switch(this) {
			case US:
				type += "US(����)";
				break;
			case UK:
				type += "UK(�^��)";
				break;
			case TAIWAN:
				type += "TAIWAN(�x�W)";
				break;
			case JAPAN:
				type += "JAPAN(�饻)";
				break;
		}
		return type;
	}
	public String getInfo() {
		String info = "";
		switch(this) {
			case US:
				info += "�����N�����Q���h�ĥi�f";
				break;
			case UK:
				info += "�^���U�ȯ��Q���y���r��";
				break;
			case TAIWAN:
				info += "�x�W�p�Y�g�ٹ�f�S����";
				break;
			case JAPAN:
				info += "�馡�Ʋz�Q���h�˥B�״I";
				break;
		}
		return info;
	}
}
