import model.Board;
import model.Player;
import view.GameScene;
import java.util.Scanner;

public class Controller {

	private GameScene gameSc;
	private Player player1;
	private Player player2;
	private Player pRobot;
	private Player activePlayer;
	private int players;
	private boolean turn;
	private String message;


	/**
	 *
	 * @param b takes a Board object
	 * @param p1 takes a Player object
	 * @param p2 takes a Player object
	 * @param gs takes a GameScene object
	 */
	public Controller(Board b, Player p1, Player p2, GameScene gs){
			gameSc = gs;
			turn = true;
			if(ranDom()){
				activePlayer = p1;
			}
			else activePlayer = p2;

			System.out.println("active player is="+activePlayer);

			p1.setRange(1, 6); //set range of control for player1
			p2.setRange(7, 12); //set range of control for player2

			gs.setWinText(getMessage());

			populateBoard(b);

			act(b, activePlayer, 9);
	}

	/**
	 * generates a boolean value true or false
	 * @return returns true or false radnomly
	 */
	private boolean ranDom(){
		return Math.random() < 0.45;
	}


	/**
	 * add 4 seeds to each house
	 *
	 *
	 * @param b takes a Board object
	 */
	private void populateBoard(Board b){
		for(int i=12;i>=1;i--){
			gameSc.setButton(i,4);
		}
	}

	/**
	 *  updates Board with new values
	 *
	 * @param b takes a Board object
	 */
	private void updateBoard(Board b){
		for(int i=1;i<=12;i++){
			gameSc.updateButton(i,b.getHouseSize(i));
			System.out.println("going to insert"+b.getHouseSize(i));
		}
	}


	/**
	 * for testing, it prints values for each house
	 * @param b takes a Board object
	 * @param p takes a Player object
	 */
	private void print(Board b, Player p){
		System.out.println("  collected is= "+p.getCollected());
		System.out.println("  1 it has "+b.getHouseSize(1));
		System.out.println("  2 it has "+b.getHouseSize(2));
		System.out.println("  3 it has "+b.getHouseSize(3));
		System.out.println("  4 it has "+b.getHouseSize(4));
		System.out.println("  5 it has "+b.getHouseSize(5));
		System.out.println("  6 it has "+b.getHouseSize(6));
		System.out.println("  7 it has "+b.getHouseSize(7));
		System.out.println("  8 it has "+b.getHouseSize(8));
		System.out.println("  9 it has "+b.getHouseSize(9));
		System.out.println("  10 it has "+b.getHouseSize(10));
		System.out.println("  11 it has "+b.getHouseSize(11));
		System.out.println("  12 it has "+b.getHouseSize(12));
		//System.out.println("player1  SCORE IS="+p.getScore());
		//System.out.println("player1 SCORE IS="+player2.getScore());

	}

	/**
	 * check if either player has won
	 * @return
	 */
	boolean hasWon(){
		message ="";
		if(player1.getPoints() >= 25) {
			message=player1+" won the game!!";

			return true;
		}
		else if(player2.getPoints() >= 25) {
			message=player2+" won the game!!";
			return true;
		}
		return false;
	}

	/**
	 *
	 * @return message
	 */
	public String getMessage(){
		return message;
	}

	/**
	 * checks if the game will involve multyplayer or single
	 *
	 * @return true if is in one player mode, false if multiplayer
	 */
	private boolean isSinglePlayer(){
		if(players == 1){
			return true;
		}
		return false;
	}

	/**
	 * sets number of players
	 * @param n set number of players
	 */
	private void setPlayers(int n){
		players = n;
	}

	/**
	 * switches turn from a player to another
	 */
	void switchTurn(){
		if(activePlayer==player1) {
			activePlayer=player2;
		}
		else {
			activePlayer=player2;
		}
	}

	/**
	 *
	 * @param b takes a Board object
	 * @param p takes a Player object
	 * @param n takes an integer which will be the position of the house
	 */
	void act(Board b, Player p, int n){
		Scanner sc = new Scanner(System.in);
		print(b, p);
		boolean play = true;
		int go = -1;
		while(play){

		int lastIndex = 0;
		int answer = 0;
		int index = 0;

		//check if house can be picked, means it has at least one element in
		while(!p.isPickable(b.getHouses(), answer)){
			System.out.println("pick a non empty house");
			answer = sc.nextInt();
		}


		//pick house
		p.pickHouse(b.getHouses(), answer);
		index= answer+1;
		checkPlayable(b);
		for(int i=p.getCollected();i>0;i--){

			//if index is higher than the board size, reset the index to 1
			if(index > b.getBoardSize()) index = 1;
			if(index < 1) index = 12;

			//if index is equal to current index where seeds have been picked from, go to next index
			if(index == answer) index++;

			//start sowing
			p.sow(b.getHouse(index));

			//if there are no more seeds in hand, don't move to next index
			if(p.getCollected() > 0) index++;

		}
		lastIndex = index;

		//Collect wins
		if(!p.isInRange(lastIndex)){
			while(p.isScoreable(b.getHouse(lastIndex))){
				p.capture(b.getHouse(lastIndex));
				System.out.println("_________________________________________removed="+p.getScore()+" from="+lastIndex);

				//if index is less than the 1, reset the index to 12
				if(index < 1) lastIndex = 12;

				if(!p.isInRange(lastIndex-1)) lastIndex--;

			}
		}

		else System.out.println("out of range");

		print(b, p);
		boolean ask = true;
		while(ask){
			System.out.println("press '1' to PLAY, '0' to exit");
			go = sc.nextInt();
			if(go==0){
				ask = false;
				play = false;
			}
			else if(go==1) {
				ask = false;
				play = true;
			}
			else {
				System.out.println("Try again");
			}
			}
		}

	}

	/**
	 *
	 * @param bo takes Board object
	 * @return true if opponet has at least one seed, false if not
	 */
	public boolean checkPlayable(Board bo) {
	    int n = 6;
	    boolean isPlayable = false;

	    if(activePlayer == player1){
	      for(int i = 1; i <= 6; i++){
	        if(!(bo.getHouseSize(i) >= n)) {
	          gameSc.getButton(i).setDisable(true);
	        } else {
	          isPlayable =  true;
	        }
	        n--;
	      }
	    } else {
	      for(int x = 7; x <= 12; x++){
	        if(!(bo.getHouseSize(x) >= n)) {
	          gameSc.getButton(x).setDisable(true);
	        } else {
	          isPlayable = true;
	        }
	        n--;
	      }
	    }
	    return isPlayable;
	  }

}
