package model;

public class ScoreHouse implements Resetter {

	private int score;

	public ScoreHouse() {
		score = 0;
	}

	/**
	 * Adds value to score
	 * @param amount takes an integer value
	 */
	public void add(int amount){
		score+=amount;
	}

	/**
	 *Returns value of score
	 * */
	public int getAmount(){
		return score;
	}


	/**
	 * resets score to ZERO
	 */
	@Override
	public void reset() {
		score = 0;
	}

	@Override
	public void reset(int n) {}
}
