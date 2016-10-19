package Lottery.Game.model;

/**
 * A lottery ball
 * @author Saketh Mudrakola
 */
public class Ball {
	/**
	 * Ball Number
	 */
	int number;
	/**
	 * Assigning Ball Number
	 */
	public Ball(int number) {
		this.number = number;
	}
	/**
	 * Retrieving ball number
	 */
	public int getNumber() {
		return number;
	}
	
}