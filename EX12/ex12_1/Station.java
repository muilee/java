package ex12_1;

public class Station implements Comparable<Station>{
	String name;
	Double latitude;
	Double longitude;
	public Station (String name, double latitude, double longitude) {
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	@Override
	public int compareTo(Station o) {
		return (-1) * this.latitude.compareTo(o.latitude);
	}
	@Override
	public String toString() {
		return this.name;
	}
}
