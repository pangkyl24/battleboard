public class Ship{

	//[Class Variables]
	public int shipSize;
	public int[][] Coordinates;
	public int hits;
	
	public Ship(){ //CONSTRUCTOR
		shipSize = 2;
		Coordinates = new int[shipSize][2];
		hits = 0;
	}
	
	public Ship(int size){ //OVERLOADED CONTRUCTOR
		shipSize = size;
		Coordinates = new int[shipSize][2];
		hits = 0;
	}
	
	/*public int[] shipPos() { // Returns the shipPosition ------------> Cut out
		return shipStartEnd;
	}
	
	public boolean acceptPosition(int startX,  int startY, int endX, int endY) {
		if (startX == endX || startY == endY){ //Vertical/Horizontal -> True
			if (startX >= 10 || startY >= 10 || endX >= 10 ||endY >= 10){ //In bounds
				return false;
			}
			return true;
		}
		return false;
	}*/
	
	//[Confirms]
	public int[][] shipCoords (int startX, int startY, int endX, int endY) {
		
		
		int[][] coords = new int[shipSize][2];
		//System.out.println(coords); - SysPrint = Error Checking
		System.out.println(shipSize);
		System.out.println("Ckpt1");
		if (startX == endX || startY == endY){ //Make sure the thing isnt diagonal
			//System.out.println("Ckpt2");
			if ((startX == endX) && (Math.abs(startY - endY) + 1 == shipSize)){ // Confirming Ship Size
				//System.out.println("Ckpt3");
				for (int i = 0; i < shipSize; i++){ // Determining Ship Coordinates
					coords[i][0] = startX;
					System.out.println(coords[i][0]);
					coords[i][1] = startY + i;	
					System.out.println(coords[i][1]);
				}
			}
			else if ((startY == endY) && (Math.abs(startX - endX) + 1 == shipSize)){
				//System.out.println("Ckpt3");
				for (int i = 0; i < shipSize; i++){
					coords[i][0] = startX + i;
					System.out.println(coords[i][0]);
					coords[i][1] = startY;	
					System.out.println(coords[i][1]);
				}	
			}
		}
		Coordinates = coords;
		return coords;
		
		
	}
	
	public void getsHit(int x, int y){		
		hits += 1; //Marking that Ship was Hit
		for (int i = 0; i < shipSize; i++){
			
			if (Coordinates[i][0] == x && Coordinates[i][1] == y){ //Removing the Coord
				Coordinates[i][0] = -1;
				Coordinates[i][1] = -1;
			}
		}		
	}
}

