public class Ship{

	int shipSize;
	int[] shipStartEnd;
	
	public Ship(){ //CONSTRUCTOR
		shipSize = 2;
		shipStartEnd = new int[4]; // (startX, startY, endX, endY)
	}
	
	public Ship(int size){ //OVERLOADED CONTRUCTOR
		shipSize = size;
		shipStartEnd = new int[4];
	}
	
	public int[] shipPos() {
		return shipStartEnd;
	}
	
	public bool acceptPosition(int startX,  int startY, endX, endY) {
		if (startX == endX || startY == endY){ //Vertical/Horizontal -> True
			if (startX >= 10 || startY >= 10 || endX >= 10 ||endY >= 10){ //In bounds
				return false;
			}
			return true;
		}
		return false;
	}

}
