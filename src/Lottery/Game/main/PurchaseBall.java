package Lottery.Game.main;

import java.util.Scanner;

import Lottery.Game.model.Buyer;

public class PurchaseBall {
	public  boolean purchase(LotteryProvider lotteryOwner, Scanner scan, boolean ticketBought) {
		String buy = null;
		System.out.println("Please give us the buyer's name and choosen a number, like: Rakhi 45");
		while((buy = scan.nextLine()) != null) {
			String[] ss = buy.replace("-", " ").replaceAll(",", " ").replaceAll("  ", " ").split(" ");
			boolean succ = lotteryOwner.sell(new Buyer(ss[0]), Integer.parseInt(ss[1]));
			while(!succ) {
				System.out.println(LotteryPot.ERROR_MESSAGE);
				ss[1] = scan.nextLine();
				succ = lotteryOwner.sell(new Buyer(ss[0]), Integer.parseInt(ss[1]));
			}
			if(succ) {
				ticketBought = true;
				System.out.printf("Yes! %s bought ball [%s] successfully. Another purchase?[y, n]", ss[0], ss[1]);
				String anotherPurchase = scan.nextLine();
				boolean anotherPur = false;
				while(anotherPurchase != null && (anotherPurchase.equalsIgnoreCase("y") || anotherPurchase.equalsIgnoreCase("n"))) {
					if("n".equalsIgnoreCase(anotherPurchase)) {
						anotherPur = false;
						break;
					}
					else if("y".equals(anotherPurchase)) {
						anotherPur = true;
						System.out.println("\nPlease give us the buyer's name and choosen number, like: Tom 33");
						break;
					}
					else {
						anotherPurchase = scan.nextLine();
					}
				}
				if(!anotherPur) {
					break;
				}
			}
			
		}
		return ticketBought;
	}
}
