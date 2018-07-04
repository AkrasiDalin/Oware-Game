package model;

import java.util.Map;
import java.util.Stack;

public class Player implements Resetter {

	private String name;
	private ScoreHouse scoreHouse;
	private int collected;
	private int minRange;
	private int maxRange;

	/**
	 * Assigns name and score house to player
	 * */
	public Player(String name, ScoreHouse scoreHouse){
		this.name = name;
		this.scoreHouse = scoreHouse;
		this.collected = 0;
	}


	/**
	 *retrives score value
	 * */
	public int getScore(){
		return scoreHouse.getAmount();
	}

	/**
	 * selects which house to pick seeds from
	 * */
	public void pickHouse(Map<Integer, House> m, int n){
		System.out.println("map size="+m.size());
			collect(m.get(n));
	}

	/**
	 * checks if given house is non empty
	 * @param m takes a map objcet
	 * @param n takes an integer value
	 * @return ruturn true or false
	 */
	public boolean isPickable(Map<Integer, House> m, int n){
		if(n > m.size() || n < 1 || m.get(n).getAmount() < 1) return false;
		else {
			return true;
		}
	}

	/**
	 * adds seed on house
	 * @param h takes a House object
	 *
	 */
	public void sow(House h){
		if(collected != 0){
			h.add(1);
			collected-=1;
		}
	}

	/**
	 * checks if current house contains 2 or 3 elements (using 5 for quick testing)
	 * @param h takes a House object
	 * @return return true or false
	 */
	public boolean isScoreable(House h){
		if(h.getAmount() == 2 || h.getAmount() == 3){
			 return true;
		}else {
			return false;
		}

	}


	/**
	 *  collects seeds to sow
	 * @param h takes a House object
	 */

	public void collect(House h){
		collected = h.remove();
		//each player needs to have a set of houses(0-5/6-12) in whihc it can operate
	}

	/**
	 * collects seeds from given house
	 * @param h takes a House object
	 */
	public void capture(House h){
		addScore(h.remove());
	}
	/**
	 * Adds seeds to collected variable
	 */
	public void capture(){
		addScore(collected);
	}

	/**Adds score value to score house
	 *
	 * @param n takes an Integer value
	 */

	private void addScore(int n){
		scoreHouse.add(n);
	}

	/**
	 *
	 * @return returns value from score house
	 */
	public int getPoints(){
		return scoreHouse.getAmount();
	}

	/**
	 *
	 * @return rutrns value from collected hand
	 */
	public int getCollected(){
		return collected;
	}

	/**
	 * sets min and max range
	 *
	 * @param min takes an integer value
	 * @param max takes an integer value
	 */
	public void setRange(int min, int max){
		this.minRange = min;
		this.maxRange = max;
	}

	/**
	 *
	 * @return returns value of minRange
	 */
	private int getMinRange(){
		return minRange;
	}

	/**
	 *
	 * @return returns value of maxRange
	 */
	private int getMaxRange(){
		return maxRange;
	}

	/**
	 * chacks if index is in range
	 * @param n takes an integer value
	 * @return returns true or false
	 */
	public boolean isInRange(int n){
		if(n >= getMinRange() && n <= getMaxRange()) return true;
		else return false;
	}

	/**
	 * resets empties hand and score house
	 */
	public void reset(){
		scoreHouse.reset();
		collected = 0;
	}

	@Override
	public void reset(int n) {}

	public String toString(){
		return name;
	}

}
