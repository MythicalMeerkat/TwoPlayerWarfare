/**
 * TwoPlayerWarfare.java
 *
 * TwoPlayerWarfare is a console application that users can play a simple game on.
 * Written under a 1 hour time limit during a College Hackathon.
 *
 * Jeffrey Wilson
 * Texas State Univeristy 
 * March, 2018
 * 
 */
 
 import java.util.Scanner;
 import java.util.Random;

public class TwoPlayerWarfare {
    
    public static void main(String[] args) {

    	Scanner input = new Scanner(System.in);
    	
    	playerData player1 = new playerData();
    	playerData player2 = new playerData();
    	
    	gameConcrete gameData = new gameConcrete();
    	gameData.gameIntroMessage();
    	
    	while(player1.getHealthAmount() > 0 && player2.getHealthAmount() > 0) // Both Players Alive?
    	{
    		int turnCounter = 1;
    		while(turnCounter % 2 != 0 && player1.getHealthAmount() > 0)  // Player 1 Turn
    		{
    			System.out.println("--- Player 1 Info ---");
    			System.out.println();
    			
    			player1.printPlayerInfo();
				
				System.out.println();
				System.out.println("Player 1... what would you like to do?");
				System.out.println();
				int tossAction = input.nextInt();
				System.out.println();
				
				switch(tossAction) {
					default:  System.out.println("Command not recognized!");
							  System.out.println("Skipping your turn!");	
							  break;
					case 1: tossAction = 1;
							int randAmmo = calcRandomItemInstance(gameData.getAmmoAddRange());
							player1.addAmmo(randAmmo);
							System.out.println("--- Added " + randAmmo + " piece(s) of ammo ---");
							System.out.println();
							break;
					case 2: tossAction = 2;
							if(player1.getHealthAmount() > 0 && player1.getHealthAmount() < 100)
							{
								int randHealth = calcRandomItemInstance(gameData.getHealthAddRange());
								player1.addHealth(randHealth);
								System.out.println("--- Added " + randHealth + " health ---");
								System.out.println();
								break;
							}
							else {
								System.out.println("--- You Have Max Health ---");
								System.out.println();
								System.out.println("--- Adding Random Amount of Armor Instead ---");
								System.out.println();
							}
					case 3: tossAction = 3;
							int randArmor = calcRandomItemInstance(gameData.getArmorAddRange());
							player1.addArmor(randArmor);
							System.out.println("--- Added " + randArmor + " piece(s) of armor ---");
							System.out.println();
							break;
					case 4: tossAction = 4;
							if(player1.getAmmoCount() > 0)
							{
								player1.fireAmmo();
								if(player2.getArmorAmount() >= 2)
								{
								
								player2.loseArmor();
								System.out.println("--- Player 2 has lost two pieces of armor ---");
								}
								else{
									int randDamage = calcRandomItemInstance(gameData.getDamageRange());
									player2.loseHealth(randDamage);
									System.out.println("--- Insufficient Armor ---");
									System.out.println();
									System.out.println("--- Attacked opponent with " + randDamage+ " damage ---");
								}
							}
							else {
								System.out.println("--- Out of Ammo ---");
								System.out.println("--- No damage done ---");
							}
							
							System.out.println();
							break;
						}
				turnCounter++;
    		}
    		System.out.println();
    		
    		while(turnCounter % 2 == 0 && player2.getHealthAmount() > 0)  // Player 2 Turn
    		{
    			System.out.println("--- Player 2 Info ---");
    			System.out.println();
				
				player2.printPlayerInfo();
				System.out.println();
				System.out.println("Player 2... what would you like to do?");
				System.out.println();
				int tossAction = input.nextInt();
				System.out.println();
				
				switch(tossAction) {
					default:System.out.println("Command not recognized!");
							System.out.println("Skipping your turn!");	
							break;
					case 1: tossAction = 1;
							int randAmmo = calcRandomItemInstance(gameData.getAmmoAddRange());
							player2.addAmmo(randAmmo);
							System.out.println("--- Added " + randAmmo + " piece(s) of ammo ---");
							System.out.println();
							break;
					case 2: tossAction = 2;
							if(player2.getHealthAmount() > 0 && player2.getHealthAmount() < 100)
							{
								int randHealth = calcRandomItemInstance(gameData.getHealthAddRange());
								player2.addHealth(randHealth);
								System.out.println("--- Added " + randHealth + " health ---");
								System.out.println();
								break;
							}
							else {
								System.out.println("--- You Have Max Health ---");
								System.out.println();
								System.out.println("--- Adding Random Amount of Armor Instead ---");
								System.out.println();
							}
					case 3: tossAction = 3;
							int randArmor = calcRandomItemInstance(gameData.getArmorAddRange());
							player2.addArmor(randArmor);
							System.out.println("--- Added " + randArmor + " piece(s) of armor! ---");
							System.out.println();
							break;
					case 4: tossAction = 4;
							if(player2.getAmmoCount() > 0)
							{ 
								player2.fireAmmo();
								if(player1.getArmorAmount() >= 2)
								{
									player1.loseArmor();
									System.out.println("--- Player 1 has lost two pieces of armor ---");
								}
								else {
									int randDamage = calcRandomItemInstance(gameData.getDamageRange());
									player1.loseHealth(randDamage);
									System.out.println("--- Insufficient Armor ---");
									System.out.println();
									System.out.println("--- Attacked opponent with " + randDamage + " damage ---");
								}
								System.out.println();
							}
							else {
								System.out.println("--- Out of Ammo ---");
								System.out.println("--- No damage done ---");
							}
								break;
						}
    				turnCounter++;
    		System.out.println();
    	}
    }
    	if(player1.getHealthAmount() <= 0)
    	{
    		System.out.println("--- Player 2 is the Winner ---");
    		System.out.println();
    		System.out.println("--- Player 2 Stats ---");
    		System.out.println();
    		player2.printPlayerInfo();
    		System.out.println();
    	}
    	else {
    		System.out.println("--- Player 1 is the Winner ---");
    		System.out.println();
    		System.out.println("--- Player 1 Stats ---");
    		System.out.println();
    		player1.printPlayerInfo();
    		System.out.println();
    	}
    }
    
    private static int calcRandomItemInstance(int itemRange)
    {
    	Random rand = new Random();
    	int randomInstance = (rand.nextInt(itemRange) + 1);
    	return randomInstance;
    }
}

