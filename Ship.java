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

}
