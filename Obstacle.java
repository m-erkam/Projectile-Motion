
package question;

public class Obstacle {

	//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE
	private int width;			// Initializing data fields of obstacle class
	private int height;
	private double x;
	private double y;
	
	
	public Obstacle(int width, int height, int x) {		// Constructor for obstacle with width, height and x coordinate
		this.width = width;
		this.height = height;
		this.x = x;
	}

	public int getWidth() {				// Getter and setter methods
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}
	
	


	//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE
	
}

