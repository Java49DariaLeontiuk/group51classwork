package telran.goat.model;

public class Goat {
	private int count;
	public final int max;
	public static final int GOAT_LIMIT = 100;

	public Goat(int max) {
		this.max = max;
	}
	public int getCount() {
		return count;
	}
	public void incrementCount() {
		count++;
	}
}
