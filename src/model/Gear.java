package model;
public class Gear extends Movement{
	private int speed;
	private int duration;
	
	public int getSpeed() {
		return speed;
	}
	
	public int getDuration() {
		return duration;
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getSpeedAsString(){
		return ""+speed+"";
	}
	public String getDurationAsString(){
		return ""+duration+"";
	}
	
	@Override
	public String toString() {
		return "Gear [speed=" + speed + ", duration=" + duration + "]";
	}
	
	Gear(String name, int iD, int stepId, int hwAdress, int speed, int duration){
		super(name, iD, stepId, hwAdress);
		this.speed=speed;
		this.duration=duration;
	}
	
}
