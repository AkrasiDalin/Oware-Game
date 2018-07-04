package model;
import java.util.Stack;

public class House implements Resetter {
	private Stack st;
	public House(int n){
		st = new Stack();
			reset(n);
	}

	/**
	 * Adds value to house
	 * @param amount takes an integer value
	 */
	public void add(int amount){
		for(int i=0;i<amount;++i){
			st.add(1);
		}
	}

	/**
	 *Adds value to house
	 * */
	public void add(){
			st.add(1);
	}

	/**
	 *Removes value from house
	 * */
	public int remove(){
		int counter = 0;
		while(!st.empty()){
			counter+=(int)st.pop();
		}
		return counter;
	}


	/**
	 *Returns value of score
	 * */
	public int getAmount(){
		return st.size();
	}

	/**
	 * returns size of stack
	 */
	public String toString(){
		return ""+st.size();
	}

	/**
	 * resets houses values
	 */
	@Override
	public void reset() {}

	@Override
	public void reset(int n) {
		remove();
		add(n);

	}
}
