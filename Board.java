public class Board{
	final int ROW;
	final int COL;
	int board[][];
	public Board(){
		ROW = 8;
		COL = 8;
		 board = new int[ROW][COL];
	}
	
	public void showBoard(){
		for (int i = 0 ; i < ROW; i++){
				for (int j = 0; j < COL; j++) {
					System.out.print(""+ board[i][j]+ "     ");
				}
		}
	}
	
}

