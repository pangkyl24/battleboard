public class Board{
	final int ROW;
	final int COL;
	String board[][];
	public Board(){
		ROW = 10;
		COL = 10;
		board = new String[ROW][COL];
		for (int i = 0 ; i < ROW; i++){
				for (int j = 0; j < COL; j++) {
					board[i][j] = "0";
				}
			}
	}
	
	public void showBoard(){
		for (int i = 0 ; i < ROW; i++){
				for (int j = 0; j < COL; j++) {
					System.out.print(""+ board[i][j]+ "  ");
				}
				System.out.println("");
		}
	}
	
	public void shipLocation(int[] shipCoordinate){
		int startX = shipCoordinate[0];
		int startY = shipCoordinate[1];
		int endX = shipCoordinate[2];
		int endY = shipCoordinate[3];
		
		if (startX == endX){
			for (int i = startY; i <= endY; i++){
				board[startX][i] = "+";
			}
		if (startY == endY){
			for (int i = startX; i <= endX; i++){
				board[i][startY] = "+";
		}
			
		}
		
	}
		
		
	}
	
}

