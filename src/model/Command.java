package model;
import java.io.Serializable;

public class Command implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String name;
	private int iD;
	private int stepID;
	
	public String getCommandName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public int getID() {
		return iD;
	}
	public void setID(int id) {
		this.iD = id;
	}
	public int getStepID() {
		return stepID;
	}
	public void setStepID(int stepID) {
		this.stepID = stepID;
	}
	public Command(String name, int iD, int stepID) {
		this.name = name;
		this.iD = iD;
		this.stepID = stepID;
	}
	@Override
	public String toString() {
		return "Command [name=" + name + ", iD=" + iD + ", stepID=" + stepID
				+ "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + stepID;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Command other = (Command) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (stepID != other.stepID)
			return false;
		return true;
	}
	
		
	
}
