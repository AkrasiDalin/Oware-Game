package model;
import java.util.HashMap;
import java.util.Map;

public class Board implements Resetter {

	private ScoreHouse scoreHouse1;
	private ScoreHouse scoreHouse2;
	private int boardSize;
	private Map<Integer, House> houses;


	/**
	 * initialises the score houses
	 * */
	public Board(int size, ScoreHouse sc1, ScoreHouse sc2){
		scoreHouse1 = sc1;
		scoreHouse2 = sc2;
		boardSize = size;
		setupHouses(size);
	}

	/**
	 *Initialises the houses with 4 seeds each
	 * */
	public void setupHouses(int size){
		houses = new HashMap();
		for(int i=1;i<=size;++i){
			houses.put(i, new House(4));
		}
	}

	//returns amount of elements contained in a house
	public int getBoardSize(){
		return houses.size();
	}

	/**
	 * Returns content of house
	 * @param key takes an integer value
	 * @return returns an integer value
	 */
	public int getHouseSize(int key){
		if(key <= boardSize  && key > 0)
		return houses.get(key).getAmount();

		else
			return -1;
	}

	/**
	 * given a index number, returns the house at that position
	 * @param key takes an integer value
	 * @return returns a House object
	 */
	public House getHouse(int key){
		if(key <= boardSize  && key > 0)
			return houses.get(key);

			else
				return null;
	}

	/**
	 *Returns the map
	 * */
	public Map<Integer, House> getHouses(){
		return houses;
	}



	/**
	 *Retrives the score value1
	 * */
	public ScoreHouse getScoreHouse1(){
		return scoreHouse1;
	}

	/**
	 * Retrives the score value2
	 * */
	public ScoreHouse getScoreHouse2(){
		return scoreHouse2;
	}



	/**
	 * resets houses values
	 */
	@Override
	public void reset() {}

	@Override
	public void reset(int n) {
		for(int i=1;i<=houses.size();i++){
			houses.get(i).reset(n);

		}
	}

}
