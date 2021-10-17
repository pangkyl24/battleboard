public class Board{
	final int ROW;
	final int COL;
	String board[][];
	String temp_board[][];
	String colNames[] = {" ", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
	String rowNames [] = {"0","1","2","3","4","5","6","7","8","9"};
	public Board(){
		ROW = 11;
		COL = 11;
		board = new String[ROW][COL];
		temp_board = new String[ROW][COL];
		for (int i = 0 ; i < ROW; i++){
				for (int j = 0; j < COL; j++) {
					board[i][j] = "0";
				}
			}
	}

	public void showBoard(){
		int colCounter = 0;
		for (int i = 0 ; i < ROW; i++){
				for (int j = 0; j < COL; j++) {
					if (i == 0){
						System.out.print(""+colNames[j] + "  ");
					}
					else {
						if (j == 0){
							System.out.print(""+rowNames[colCounter] + "  ");
							colCounter++;
						}
						else{
							System.out.print(""+ board[i][j]+ "  ");
						}
					}

				}
				System.out.println("");
		}
	}

	public void shipLocation(int[] shipCoordinate){
		int startX = shipCoordinate[0];
		int startY = shipCoordinate[1];
		int endX = shipCoordinate[2];
		int endY = shipCoordinate[3];

		boolean checkerX = false;
		boolean checkerY = false;

		int temp;

		if (startX == endX){
			if (endY < startY){
				temp = endY;
				endY = startY;
				startY = temp;
			}
			for (int i = startY; i <= endY; i++){
				if (board[startX][i].equals("+")){
					checkerX = true;
				}
			}
			if (!checkerX){
				for (int i = startY; i <= endY; i++){
					board[startX][i] = "+";
				}
			}
		}

		if (startY == endY){
			if (endX < startX){
				temp = endX;
				endX = startX;
				startX = temp;
			}
			for (int i = startX; i <= endX; i++){
				if (board[i][startY].equals("+")){
					checkerY = true;
				}
			}
			if (!checkerY) {
				for (int i = startX; i <= endX; i++){
					board[i][startY] = "+";
					}
				}
			}

	}

	public void registerAttack(int[] attackCoordinate){
		int attackX = attackCoordinate[0];
		int attackY = attackCoordinate[1];

		if (board[attackX][attackY].equals("+")){
			board[attackX][attackY] = "M";
			System.out.println("Computer Hits");
		}

		else{
			board[attackX][attackY] = "X";
			System.out.println("Computer Misses");
		}
	}


}
