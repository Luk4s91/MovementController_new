package model;
public class Prototyp {
	
	private String nameCommand;

	public void setNameCommand(String nameCommand) {
		this.nameCommand = nameCommand;
	}
	public String getNameCommand() {
		return nameCommand;
	}
	
	@Override
	public String toString() {
		return nameCommand;
	}
	
	public Command createInstance()
	{
		if (this.nameCommand=="Gear")
		{
			Gear gearx = new Gear("Gear", 0, 0, 0, 0, 0);
			return gearx;
		}
		else if (this.nameCommand=="Direction")
		{
			Direction directionx = new Direction("Direction", 0, 0, 0, 0);
			return directionx;
		}
		else if (this.nameCommand=="Goto")
		{
			Goto gotox = new Goto("Goto", 0, 0, 0);
			return gotox;			
		}
		else if (this.nameCommand=="If")
		{
			If ifx = new If("If", 0, 0, 0, 0);
			return ifx;
		}
			
		return null; 
	}
	
	public Prototyp(String nameCommand) {
		this.nameCommand = nameCommand;
	}

}
