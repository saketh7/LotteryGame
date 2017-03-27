package Lottery.Game.main;
import java.util.Scanner;
/**
 * The main class for this application
 * @author Saketh Mudrakola
 *
 */
/* new line
*/

public class LotteryMainApp 
{
    public static void main( String[] args )
    {
    	LotteryProvider lotteryOwner = new LotteryProvider("Rakhi");
    	PurchaseBall pb=new PurchaseBall();
    	System.out.println("Qu'est ce que tu vas faire? {purchase, draw, or winners}");
    	Scanner scan = new Scanner(System.in);
    	String cmd = null;
    	int numberOfDraws = 0;
    	boolean ticketBought = false;
    	boolean drawTaken = false;
    	while((cmd = scan.nextLine()) != null) {
    		
    		if("purchase".equalsIgnoreCase(cmd)) {
    			
    			ticketBought = pb.purchase(lotteryOwner, scan, ticketBought);
    		}
    		
			if ("draw".equalsIgnoreCase(cmd)) {
				if (!ticketBought) {
					System.out.println("Please Purchase a ticket before hitting draw.");
				} else if (numberOfDraws >= 3) {
					System.out.println("Draw can not be taken morethan 3 times.");
				} else {
					LotteryWinner winner = lotteryOwner.drawABallAndGetWinner();
					System.out.printf("%5d : %s won %.2f dollars", winner.getSequence(), winner.getBuyer().getName(),
							winner.getPrize());
					drawTaken = true;
					numberOfDraws++;
				}
			}
    		
			if ("winners".equalsIgnoreCase(cmd)) {
				if (!ticketBought || !drawTaken) {
					System.out.println("Please purchase or draw a lattery before finding winners.");
				} else {
					lotteryOwner.listWinners();
					System.exit(0);
				}
			}
    		System.out.println("\nWhat are you going to do? [purchase, draw, or winners]");
    	}
    	scan.close();
    }


}
    
