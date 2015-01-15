package model;
public class Assignment extends Control{
	private int operand;
 
	Assignment(String name, int iD, int stepID, int operand){
		super(name, iD, stepID);
		this.operand=operand;
	}
 
	@Override
	public String toString() {
		return "Assignment [operand=" + operand + "]";
	}

	public int getOperand() {
		return operand;
	}

	public void increase(){
	 
	}
 
	public void decrease(){
	 
	}
}

