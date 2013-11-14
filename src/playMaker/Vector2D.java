package playMaker;


// Points don't support finding unit vectors since the x any y can only be integers
public class Vector2D {
	public double x;
	public double y;

	public Vector2D() {
		x = 0;
		y = 0;
	}

	public Vector2D(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getMagnitude() {
		return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
	}

	public Vector2D getUnitVector() {
		Vector2D result = new Vector2D();
		result.setY(y/this.getMagnitude());
		result.setX(x/this.getMagnitude());
		
		return result;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vector2D other = (Vector2D) obj;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
			return false;
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
			return false;
		return true;
	}
	
	


}
