package model;
public class If extends Goto{
	private int reference;
	
	If(String name, int iD, int stepId, int jumpAdress, int reference){
		super(name,iD,stepId,jumpAdress);
		this.reference=reference;
	}
	
	public int getReference() {
		return reference;
	}
	public String getReferenceAsString(){
		return ""+reference+"";
	}

	public void setReference(int reference) {
		this.reference = reference;
	}
	@Override
	public String toString() {
		return "If [reference=" + reference + "]";
	}
	
}