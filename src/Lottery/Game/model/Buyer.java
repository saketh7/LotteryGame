package Lottery.Game.model;



/**
 *  Buyer
 * @author Saketh Mudrakola
 *
 */
public class Buyer {
	/**
	 * Name of the buyer
	 */
	private String name;
	
	public Buyer(String name) {
		this.name = name;
	}
	/**
	 * retrieves of the buyer name
	 */
	public String getName() {
		return name;
	}
	
}