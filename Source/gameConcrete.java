//package jarTwoPlayerWarfare;

public class gameConcrete {

	// Calculations
	
	private final int ammoAddRange = 6;  // Used to calculate random possibilities
	private final int healthAddRange = 3;  // Used to calculate random possibilities
	private final int armorAddRange = 4;  // Used to calculate random possibilities
	private final int damageRange = 15;  // Used to calculate random possibilities
	
	// Items
	
	private final int ammoBox = 1;  // Amount of ammo in one box
	private final int healthPack = 5;  // Amount of Health in one pack
	private final int armorPiece = 1;  // Amount of armor given to player
	
	public int getAmmoAddRange()
	{
		return ammoAddRange;
	}
	
	public int getHealthAddRange()
	{
		return healthAddRange;
	}
	
	public int getArmorAddRange()
	{
		return armorAddRange;
	}
	
	public int getDamageRange()
	{
		return damageRange;
	}
	
	public int getAmmoBox()
	{
		return ammoBox;
	}
	
	public int getHealthPack()
	{
		return healthPack;
	}
	
	public int getArmorPiece()
	{
		return armorPiece;
	}
	
	public void gameIntroMessage()
	{
		System.out.println("--- Welcome to Two Player Warfare ---");
    	System.out.println();
    	System.out.println("--- Created By Jeff Wilson ---");
    	System.out.println();
    	System.out.println("--- Rules ---");
    	System.out.println();
    	System.out.println("Press '1' to get random amount of ammo!");
		System.out.println("Press '2' to get random health percent!");
		System.out.println("Press '3' to get random amount of armor!  (2 Pieces Blocks 1 bullet)");
		System.out.println("Press '4' to attack your enemy with random damage!");
		System.out.println();
	}
}