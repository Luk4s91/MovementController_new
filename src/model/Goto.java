package model;
public class Goto extends Control{
	private int jumpAdress;
	
	public Goto(String name, int iD, int stepId, int jumpAdress) {
		super(name, iD, stepId);
		this.jumpAdress = jumpAdress;
	}

	public int getJumpAdress() {
		return jumpAdress;
	}
	
	public String getJumpAdressAsString(){
		return ""+jumpAdress+"";
	}
	
	@Override
	public String toString() {
		return "Goto [jumpAdress=" + jumpAdress + "]";
	}
	
}
