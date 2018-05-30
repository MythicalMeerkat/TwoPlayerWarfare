//package jarTwoPlayerWarfare;

public class playerData implements gameInterface
{
	private gameConcrete gameData;
	private int ammoCount;  // Starting Ammo for player, can be changed during game
	private int healthPercent;  // Starting Health, can be changed during game
	private int armorPercent;  // Starting Armor, can be changed durning game
	
	public playerData()
	{
		gameData = new gameConcrete();
		ammoCount = 2;
		healthPercent = 100;
		armorPercent = 2;
	}
	
	
	public int addAmmo(int itemCount)
	{
		for(int counter = 0; counter < itemCount; counter++)
		{
			ammoCount += gameData.getAmmoBox();
		}
		return ammoCount;
	}


	public int addHealth(int itemCount)
	{
		for(int counter = 0; counter < itemCount; counter++)
		{
			healthPercent += gameData.getHealthPack();
		}
		return healthPercent;
	}


	public int addArmor(int itemCount)
	{
		for(int counter = 0; counter < itemCount; counter++)
		{
			armorPercent += gameData.getArmorPiece();
		}
		return armorPercent;
	}
	
	public int loseHealth(int damageAmount)
	{
		healthPercent -= damageAmount;
		return healthPercent;
	}
	
	public int loseArmor()
	{
		armorPercent -= gameData.getArmorPiece() * 2;
		return armorPercent;
	}
	
	public int fireAmmo()
	{
		ammoCount -= 1;
		return ammoCount;
	}
	
	public int getAmmoCount()
	{
		return ammoCount;
	}
	
	public int getArmorAmount()
	{
		return armorPercent;
	}
	
	public int getHealthAmount()
	{
		return healthPercent;
	}
	
	public void printPlayerInfo()
	{
		System.out.println("Ammo Count: " + ammoCount);
		System.out.println("Health Percent: " + healthPercent);
		System.out.println("Armor Pieces: " + armorPercent);
	}

	

	
}