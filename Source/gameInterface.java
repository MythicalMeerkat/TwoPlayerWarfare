//package jarTwoPlayerWarfare;

public abstract interface gameInterface
{
	public abstract int addAmmo(int itemCount);


	public abstract int addHealth(int itemCount);


	public abstract int addArmor(int itemCount);
	
	
	public abstract int fireAmmo();
	
	
	public abstract int loseHealth(int damageAmount);
}