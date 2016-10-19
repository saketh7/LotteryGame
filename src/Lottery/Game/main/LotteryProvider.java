package Lottery.Game.main;

import java.util.HashMap;
import java.util.Map;

import Lottery.Game.main.LotteryWinner;
import Lottery.Game.model.Ball;
import Lottery.Game.model.Buyer;
/**
 *  Lottery Seller
 * @author Saketh Mudrakola
 *
 */
public class LotteryProvider {
	
	/**
	 * Lottery Seller Name
	 */
	private String sellerName;

	/**
	 *Ongoing Lottery Ball Pot
	 */
	private LotteryPot pot = new LotteryPot(200);
	
	/**
	 * Sold Tickets, Ball numbers
	 */
	private Map<Integer, Buyer> ticketsSold = new HashMap<Integer, Buyer>();
	
	/**
	 * Winners
	 */
	private Map<Integer, LotteryWinner> winners = new HashMap<Integer, LotteryWinner>();
	
	public LotteryProvider(String name) {
		this.sellerName = name;
	}
	
	/**
	 * Assign a Ball to a Buyer
	 * @param buyer
	 * @param number
	 * @return
	 */
	public boolean sell(Buyer buyer, Integer number) {
		while(pot.sellTicket(number)) {
			ticketsSold.put(number, buyer);
			return true;
		}
		return false;
	}
	
	/**
	 * Draw a Ball and Confirm the Winner
	 * @return
	 */
	public LotteryWinner drawABallAndGetWinner() {
		boolean valid = false;
		while(!valid) {
			Ball ball = pot.drawABall();
			valid = ticketsSold.containsKey(ball.getNumber());
			if(valid) {
				LotteryWinner winner = new LotteryWinner(ticketsSold.get(ball.getNumber()));
				winners.put(winner.getSequence(), winner);
				pot.confirmPrize(winner);
				return winner;
			}
		}
		return null;
	}

	/**
	 * Display Winners List
	 */
	public void listWinners() {
		System.out.println("1st ball\t\t\t2nd ball\t\t\t3rd ball");
		for(int i = 1; i <= winners.size(); i++) {
			LotteryWinner winner = winners.get(i);
			System.out.printf("%s: $%.2f", winner.getBuyer().getName(), winner.getPrize() );
			System.out.print("\t\t\t");
		}
		System.out.println();
	}
	/**
	 * Retrieves Seller Name
	 */
	public String getName() {
		return sellerName;
	}
	
}