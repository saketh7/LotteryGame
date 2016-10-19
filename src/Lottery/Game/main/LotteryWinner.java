package Lottery.Game.main;

import java.math.BigDecimal;

import Lottery.Game.model.Buyer;
/**
 * The Winner 
 * @author Saketh Mudrakola
 *
 */
public class LotteryWinner {
	// seq generator used to sequence unique and increment it
	private static SequenceGenerator seqGenerator = new SequenceGenerator();
	
	// Sequence of the Winner
	private int seq = -1;
	
	//  Buyer
	private Buyer buyer;
	
	// Amount of the Prize
	private BigDecimal prize = new BigDecimal(0);
	
	// Ensure the Prize can only be set once
	private boolean prizeSet = false;
	
	public LotteryWinner(Buyer buyer) {
		this.buyer = buyer;
		this.seq = seqGenerator.nextSequence();
	}
	
	public int getSequence() {
		return seq;
	}
	public Buyer getBuyer() {
		return buyer;
	}
	public BigDecimal getPrize() {
		return prize;
	}
	/**
	 * set the price
	 * @param prize2
	 */
	public void setPrize(BigDecimal prize2) {
		if(!this.prizeSet) {
			this.prize = prize2;
			this.prizeSet = true;
		}
	}
}

class SequenceGenerator {
	int i = 0;
	
	int nextSequence() {
		return ++i;
	}
}