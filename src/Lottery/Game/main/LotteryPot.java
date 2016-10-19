package Lottery.Game.main;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Lottery.Game.model.Ball;

/**
 * The Lottery Pot
 * @author Saketh Mudrakola
 *
 */
public class LotteryPot {
	/**
	 * Total Balls numbers
	 */
	final int TOTAL_BALLS = 50;
	
	/**
	 * Initial Total Prize
	 */
	BigDecimal totalPrize;
	
	/**
	 * Prize left in pot after Paying Buyers
	 */
	BigDecimal prizeInPot;
	
	/**
	 * Balls in the Pot
	 */
	List<Ball> balls = new ArrayList<Ball>();

	/**
	 *  Tickets Sold, Numbers of Balls
	 */
	List<Integer> ticketsSold = new ArrayList<Integer>();
	
	public static String ERROR_MESSAGE = null;
	
	
	public LotteryPot(double totalPrize) {
		this.totalPrize = new BigDecimal(totalPrize);
		this.prizeInPot = new BigDecimal(totalPrize);
		for(int i = 0; i < TOTAL_BALLS; i++) {
			Ball ball = new Ball(i + 1);
			balls.add(ball);
		}
	}
	
	/**
	 * sell a ball with specified number to a user, needs to check if the number has been sold out.
	 * @param the number of the ball 
	 * @return
	 */
	public boolean sellTicket(Integer number) {
		if(number != null && !(number > 0 && number <=50)){
			ERROR_MESSAGE = "Please choose number between 1 to 50, please try another ball number (Just the number):";
			return false;
		}
		if(this.ticketsSold != null && this.ticketsSold.size() > 50){
			ERROR_MESSAGE = "All Tickets are soldout.";
			return false;
		}	
		if(!this.ticketsSold.contains(number)) {
			this.ticketsSold.add(number);
			return true;
		} else {
			ERROR_MESSAGE = number + " has been sold out, please try another ball number (Just the number):";
		}
		return false;
	}
	
	/**
	 * draw a ball randomly
	 * @return
	 */
	public Ball drawABall() {
		Random rnd = new Random();
		int index = rnd.nextInt(balls.size());
		Ball ball = balls.get(index);
		balls.remove(index);
		return ball;
	}

	/**
	 * to confirm the prize of the winner after drawing a ball
	 * @param winner
	 */
	public void confirmPrize(LotteryWinner winner) {
		BigDecimal prize = this.totalPrize.multiply(new BigDecimal(0.50).multiply(getPrizeRatio(winner.getSequence())));
		winner.setPrize(prize);
		prizeInPot = prizeInPot.subtract(prize);
	}
	/**
	 * determine the amount ratio of the prize by the sequence of the number
	 * @param seq
	 * @return
	 */
	private BigDecimal getPrizeRatio(int seq) {
		return new BigDecimal((seq == 1?0.75:(seq == 2?0.15:(seq == 3?0.10:0))));
	}
}