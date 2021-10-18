public class Ship{

	//[Class Variables]
	public int shipSize;
	public int[] coordinates;
	public int hits;

	public Ship(){ //CONSTRUCTOR
		shipSize = 2;
		coordinates = new int[4];
		hits = 0;
	}

	public Ship(int size){ //OVERLOADED CONTRUCTOR
		shipSize = size;
		coordinates = new int[4];
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
	public void shipCoords (int startX, int startY, int endX, int endY) {
		// Get necessary coordinates and add them to coordinates array
		coordinates[0] = startX;
		coordinates[1] = startY;
		coordinates[2] = endX;
		coordinates[3] = endX;
		/*int[][] coords = new int[shipSize][2];
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
		return coords;*/


	}

	public int[] returnCoords(){ // just return coordinates for board; need to update to not pass the reference
		System.out.println(coordinates);
		return coordinates;

	}


	public void aiCoords(int x, int y, int horiVerti){ // will control the coordinates for the computer; split graph into 4 sections

		coordinates[0] = x;
		coordinates[1] = y;

		if (horiVerti == 0){ //Horizontal

			coordinates[3] = y;
			if (x <= 5){
				coordinates[2] = x+shipSize-1;
			}
			else {
				coordinates[2] = x-shipSize+1;
			}

		}
		else if (horiVerti == 1){ //Vertical

			coordinates[2] = x;
			if (y <= 5){
				coordinates[3] = y+shipSize-1;
			}
			else {
				coordinates[3] = y-shipSize+1;
			}

		}
		//System.out.println("(" + Coordinates[0] + ", " + Coordinates[1] + ", " + Coordinates[2] + ", " + Coordinates[3] + ")");

	}

	public void getsHit(int x, int y){
		hits += 1; //Marking that Ship was Hit
		for (int i = 0; i < shipSize; i++){

			/*if (Coordinates[i][0] == x && Coordinates[i][1] == y){ //Removing the Coord
				Coordinates[i][0] = -1;
				Coordinates[i][1] = -1;
			}*/
		}
	}

	public boolean onBoard (int startX, int startY, int endX, int endY){ // make sure coordinates are on board to ensure game will work
		if (startX > 10 || startX < 1){ // board is 10 x 10 so need to check with 10 and 1
			return false;
		}
		if (startY > 10 || startY < 1){ // board is 10 x 10 so need to check with 10 and 1
			return false;
		}
		if (endX > 10 || endX < 1){ // board is 10 x 10 so need to check with 10 and 1
			return false;
		}
		if (endY > 10 || endY < 1){ // board is 10 x 10 so need to check with 10 and 1
			return false;
		}
		return true;

	}







}
