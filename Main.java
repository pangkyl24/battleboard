/*Test file for building and running your program - the main is to support
*   development in Repl.it
*
*/

public class Battle {

public static void main ( String[] args) {
	Board playerShips = new Board();
	Board playerHits = new Board();
	playerHits.showBoard();
	System.out.println("+--+--+--+--+--+--+--+ ");
	playerShips.showBoard();
	System.out.println("");
	int arr[] = {1,1,1,5};
	playerShips.shipLocation(arr);
	playerHits.showBoard();
	System.out.println("+--+--+--+--+--+--+--+ ");
	playerShips.showBoard();


}  //close main method

}  //close the Main class
