package model;
public class Movement extends Command {
	public int hwAdress;
	
	Movement(String name, int iD, int stepID, int hwAdress){
		super(name, iD, stepID);
		this.hwAdress=hwAdress;
	}

	public int getHwAdress() {
		return hwAdress;
	}

	@Override
	public String toString() {
		return super.toString()+"Movement [hwAdress=" + hwAdress + "]";
	}

}
