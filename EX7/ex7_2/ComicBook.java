package ex7_2;

public class ComicBook extends Book{
	ComicBook (String name, double price, String author) {
		super(name, price, author);
	}
	@Override
	public double getSellPrice() {
		return this.getPrice() * 0.8;
	}
	
	@Override
	public String toString() {
		return this.getName() + "  "+ this.getPrice() + "  " + this.getAuthor();
	}
}
