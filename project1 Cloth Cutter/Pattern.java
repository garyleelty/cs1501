
public class Pattern {
	private int width;
	private int height;
	private int value;
	private String name;
	
	public Pattern(int w, int h, int v, String n) {
		this.width 	= w;
		this.height = h;
		this.value 	= v;
		this.name 	= n;
	}
	
	public int width() {

		return this.width;
	}
	
	public int height() {

		return this.height;
	}
	
	public int value() {

		return this.value;
	}
	
	public String name() {

		return this.name;
	}
}