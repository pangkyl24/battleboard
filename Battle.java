/*Test file for building and running your program - the main is to support
*   development in Repl.it
*
*/


// ASCII Art reference: https://ascii.co.uk/art/battleship

import java.util.*;

public class Battle {


public static void main ( String[] args) {
	Board playerShips = new Board(); // load in player board with ships
	Board playerHits = new Board(); // load player attack board
	Board computerShips = new Board(); // load computer board with ships

	Scanner scan = new Scanner(System.in);  // scaner

	String colNamesString = " ABCDEFGHIJ  "; // Name of columns on board to use when player enters in attack coordinates
	String rowNamesString = "0123456789 "; // Name of row on board to use when player enters in attack coordinates



	// Introduction to game; ASCII Art reference: https://ascii.co.uk/art/battleship
	System.out.println("");
	System.out.println("                                 # #  ( )");
  System.out.println("                              ___#_#___|__");
  System.out.println("                             _  |____________|  _");
  System.out.println("                      _=====| | |            | | |==== _");
  System.out.println("                =====| |.---------------------------. | |====");
  System.out.println("  <--------------------'   .  .  .  .  .  .  .  .   '--------------|");
  System.out.println("     |                                                            |");
  System.out.println("     |_______________________________________________WWS_________|");

	System.out.println("");
	System.out.println("");
	System.out.println("");
	System.out.println("");
	// Menu
	System.out.println("WELCOME TO BATTLESHIP!");
	System.out.println("Press Enter key to start game...");
	scan.nextLine();
	//Instructions
	System.out.println("INSTRUCTIONS");
	System.out.println("Welcome to BattleShip! Your goal is to sink the computer's ships, before the computer sinks yours. You each have 3 ships to place on a 10 x 10 board.");
	System.out.println("Press Enter key to continue...");
	scan.nextLine();
	System.out.println("USER INTERFACE");
	System.out.println("When you play, you can only see your own board. Your board consists of two parts that are separated by dashes (-) and pluses (+). This boundary seperates your ATTACKING board (top) from your STRATEGIC board (bottom). That ATTACKING board is where you will be able to see your hits and misses againt the computer. The STRATEGIC board is where you can see your ships and the computer's hits and misses, marked by H and M respectively. ");
	System.out.println("Here is a picture of an empty board: \n");
	playerHits.showBoard();
	System.out.println("   +--+--+--+--+--+--+--+--+--+ ");
	playerShips.showBoard();
	System.out.println("Press Enter key to continue...");
	scan.nextLine();
	System.out.println();
	System.out.println("HOW TO PLACE SHIPS");
	System.out.println("When prompted, enter the letter and integer coordinates for both ends of your ships on the STRATEGIC board. You can not place ships diagnonally nor can you overlap any ships. Also, make sure that each ship is plaed within the board. ");
	System.out.println("Press Enter key to continue...");
	scan.nextLine();
	System.out.println("ATTACKING");
	System.out.println("When prompted, enter the letter and integer coordinates of the location on your ATTACKING board. Hits will be marked with an @ and misses with an X.");
	System.out.println("Press Enter to start playing");
	scan.nextLine();

	//Place all ships
	// Need to do this part still. Ship class is almost complete and will add into main once done

	//Make ships
	System.out.println("You will have 3 ships that you can place, of sizes 2, 3, and 4. Generating ships ... ");
	Ship S2 = new Ship();
	Ship S3 = new Ship(3);
	Ship S4 = new Ship(4);
	Ship ships[] = {S2, S3, S4};

	//need to convert from int to string later in program, so make variables that can store each variable type
	String xStartStringPlayer;
	String yStartStringPlayer;
	String xEndStringPlayer;
	String yEndStringPlayer;
	int xStartPlayer;
	int yStartPlayer;
	int xEndPlayer;
	int yEndPlayer;

	//check if ship is fine
	boolean boardChecker;

	// coordinate holder
	int[] coord = new int[4];

	//get ship coordinates for each ship
	for (int i = 0; i < 3; i++) {
		System.out.println("Place your ship with length " + (i + 2) + ". You will need to place the specify the start end end coordinates of the Ship" );
		System.out.print("Enter a row coordinate as an integer for the start: ");
		xStartStringPlayer = (scan.nextLine()).toUpperCase();
		System.out.print("Enter an uppercase letter for the column of the start of the ship: ");
		yStartStringPlayer = (scan.nextLine()).toUpperCase();

		yStartPlayer = (colNamesString).indexOf(yStartStringPlayer); // get index of string to match with index of board
		xStartPlayer = (rowNamesString).indexOf(xStartStringPlayer); // get index of string to match with index of board

		System.out.print("Enter a row coordinate as an integer for the end: ");
		xEndStringPlayer = (scan.nextLine()).toUpperCase();
		System.out.print("Enter an uppercase letter for the column of the end of the ship: ");
		yEndStringPlayer = (scan.nextLine()).toUpperCase();

		yEndPlayer = (colNamesString).indexOf(yEndStringPlayer); // get index of string to match with index of board
		xEndPlayer = (rowNamesString).indexOf(xEndStringPlayer); // get index of string to match with index of board
		boardChecker = ships[i].onBoard(xStartPlayer+1, yStartPlayer, xEndPlayer+1, yEndPlayer); // check to make sure on board
		if (!boardChecker){ // if checking fails
			System.out.println("Ship is outside the board. Place your ship again");
			i--;
		}
		if(boardChecker){
			// update coordinate to be placed
			coord[0] = xStartPlayer;
			coord[1] = yStartPlayer;
			coord[2] = xEndPlayer;
			coord[3] = yEndPlayer;
			ships[i].shipCoords(xStartPlayer + 1, yStartPlayer, xEndPlayer + 1, yEndPlayer); // enter ship coordinate into ship class because will need to refernce later
			playerShips.shipLocation(coord); // place coordinate
			playerHits.showBoard(); // show graph again
			System.out.println("+--+--+--+--+--+--+--+--+--+ ");
			playerShips.showBoard();
		}


	}




	String attackLetter; //Player will enter string for attack column
	int attackNumberCol; //Convert string for attack to integer for indexing
	String attackNumberAsString; //Player will enter string for attack row
	int attackNumberRow; //Convert string for attack to integer for indexing
	boolean playerSucess; // checks if player was sucessful in hitting ship
	boolean computerSucess; // checks if computer was sucessful in hitting ship
	String buffer; //buffer

	int computerAttackX; // computer X attack coordinate
	int computerAttackY; // computer Y attack coordinate



	//Begin game
	while (!gameOver){ // Keep going until game ends
		//Get attack coordinates from player
		System.out.println("Guess where to attack. You will need to enter a letter and an integer coordinate as integers. ");
		System.out.print("Enter an uppercase letter: ");
		attackLetter = (scan.nextLine()).toUpperCase(); // convert input to uppercase
		attackNumberCol = (colNamesString).indexOf(attackLetter); // Get index of letter so to enter into attack method of Board.java
		System.out.print("Enter a row coordinate as an integer: ");
		attackNumberAsString = scan.nextLine(); // convert input to uppercase
		attackNumberRow = (rowNamesString).indexOf(attackNumberAsString); // Get index of number (which is a string right now) so to enter into attack method of Board.java

		//Attack computer ships
		System.out.println();
		System.out.print("Firing missles at enemy: ");
		playerSucess = computerShips.registerAttack(attackNumberRow+1, attackNumberCol); // register the players attack on computer; return true if hit
		playerHits.markAttack(attackNumberRow+1, attackNumberCol, playerSucess); // if player hit, update player attack board as needed
		// Show board
		playerHits.showBoard();
		System.out.println("   +--+--+--+--+--+--+--+--+--+ ");
		playerShips.showBoard();
		System.out.println();
		System.out.println("You fired at " + rowNamesString.substring(attackNumberRow, attackNumberRow+1) + colNamesString.substring(attackNumberCol, attackNumberCol+1));


		//Generate attack coordinates from computer and attack player
		computerAttackX = (int) (Math.random() * 9 + 1); //random number from 1 to 10
		computerAttackY = (int) (Math.random() * 9 + 1); //random number from 1 to 10
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.print("Enemy firing missles: ");
		computerSucess = playerShips.registerAttack(computerAttackX, computerAttackY); // register attack on player board; mark if computer hits ship
		// Show board
		playerHits.showBoard();
		System.out.println("   +--+--+--+--+--+--+--+--+--+ ");
		playerShips.showBoard();
		System.out.println();
		System.out.println("Enemy fired at " + rowNamesString.substring(computerAttackX-1, computerAttackX) + colNamesString.substring(computerAttackY, computerAttackY+1));
		System.out.println();
		System.out.println();



	}

	//Still need to add in stopping mechanism to game once ship.java is complete



}  //close main method

}  //close the Main class
