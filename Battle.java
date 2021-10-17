/*Test file for building and running your program - the main is to support
*   development in Repl.it
*
*/
import java.util.*;

public class Battle {


public static void main ( String[] args) {
	Board playerShips = new Board();
	Board playerHits = new Board();
	Board computerShips = new Board();
	Scanner scan = new Scanner(System.in);



	// Introduction to game
	System.out.println("INSTRUCTIONS");
	System.out.println("Welcome to BattleShip! Your goal is to sink the computer's ships, before the computer sinks yours. You each have 3 ships to place on a 10 x 10 board.");
	System.out.println("Press Enter key to continue...");
	scan.nextLine();
	System.out.println("USER INTERFACE");
	System.out.println("When you play, you can only see your own board. Your board consists of two parts that are separated by dashes (-) and pluses (+). This boundary seperates your ATTACKING board (top) from your STRATEGIC board (bottom). That ATTACKING board is where you will be able to see your hits and misses againt the computer. The STRATEGIC board is where you can see your ships and the computer's hits and misses, marked by H and M respectively. ");
	System.out.println("Here is a picture of an empty board: \n");
	playerHits.showBoard();
	System.out.println("+--+--+--+--+--+--+--+--+--+ ");
	playerShips.showBoard();
	System.out.println("Press Enter key to continue...");
	scan.nextLine();
	System.out.println();
	System.out.println("HOW TO PLACE SHIPS");
	System.out.println("When prompted, enter the X and Y coordinates as integers of the two ends of your ships on the STRATEGIC board. You can not place ships diagnonally nor can you overlap any ships. Also, make sure that each ship is plaed within the board. ");
	System.out.println("Press Enter key to continue...");
	scan.nextLine();
	System.out.println("ATTACKING");
	System.out.println("When prompted, enter the X and Y coordinates of the location on your ATTACKING board. Hits will be marked with an @ and misses with an X");
	System.out.println("Press Enter to start playing");
	scan.nextLine();

	//Place all ships
	//some variable called gameOver that becomes true when someone loses



	/*
	boolean gameOver = false;
	int arr[] = {1,1,1,5};
	playerShips.shipLocation(arr);
	playerHits.showBoard();
	System.out.println("+--+--+--+--+--+--+--+--+--+ ");
	playerShips.showBoard();
	*/






	//Begin game
	while (!gameOver){
		System.out.println("Guess where to attack. You will need to enter an X and Y coordinate as integers. ");
		System.out.println("Enter X coordinate: ");

		System.out.println("Enter Y coordinate: ");



		System.out.println();
		System.out.println();
		System.out.println();
		int arr2[] = {0,1};
		playerShips.registerAttack(arr2);
		playerHits.showBoard();
		System.out.println("+--+--+--+--+--+--+--+--+--+ ");
		playerShips.showBoard();
	}


}  //close main method

}  //close the Main class
