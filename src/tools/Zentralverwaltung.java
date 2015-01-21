package tools;
import java.util.Properties;
import java.util.Vector;

import model.Command;
import model.Prototyp;


public class Zentralverwaltung implements Interface{
	private Vector <Prototyp> prototypen = new Vector <Prototyp>();    //Es soll von jedem Vektor nur einen geben.

	private Vector <Command> commands = new Vector <Command>();
	
	private static Zentralverwaltung instance = null;
	
	private Zentralverwaltung(){}  //private damit nur ein Objekt davon erstellt wird.
	
	public static Zentralverwaltung createInstance(){
		if(instance==null)
			instance =  new Zentralverwaltung();
		return instance;
	}
	public Vector<Prototyp> getPrototypen() {
		return prototypen;
	}
	public Vector<Command> getCommand() {
		return commands;
	}
	public Prototyp vPrototypenObject(int iD){
		return prototypen.elementAt(iD);
	}
	public String vPrototypenToString(){
		return prototypen.toString();
	}
	public String vcommandsToString(){
		return commands.toString();
	}
	public void createPrototypes()
	{
		prototypen.addElement(new Prototyp("Direction")); //Fuegt ein Prototyp-Objekt in die Liste ein.
		prototypen.addElement(new Prototyp("Gear"));
		prototypen.addElement(new Prototyp("Goto"));
		prototypen.addElement(new Prototyp("If"));
	}	
	public void addStep(Prototyp prototyp)
	{	
		commands.addElement(prototyp.createInstance()); //Fuegt vom ausgewaehlten Prototyp ein Command-Objekt ein.
	}
	public void removeStep(int iD)
	{
		if(commands.size()>iD){
		commands.remove(iD);
		}
	}
	public void incOrder(int iD)
	{
		if(!commands.firstElement().equals(commands.elementAt(iD)))
		{
		commands.addElement(commands.elementAt(iD-1)); //Temp in Vektorliste
//		System.out.println("1: " + commands);
		commands.setElementAt(commands.elementAt(iD), iD-1);
//		System.out.println("2: " + commands);
		commands.setElementAt(commands.lastElement(), iD);
//		System.out.println("3: " + commands);
		commands.removeElementAt(commands.size()-1);
		//commands.removeElementAt(commands.lastIndexOf(commands)+1);
		}
	}
	public void decOrder(int iD)
	{
		if(!commands.lastElement().equals(commands.elementAt(iD)))
		{
		commands.addElement(commands.elementAt(iD+1)); //Temp in Vektorliste
		commands.setElementAt(commands.elementAt(iD), iD+1);
		commands.setElementAt(commands.lastElement(), iD);
		commands.removeElementAt(commands.size()-1);
		//commands.removeElementAt(commands.lastIndexOf(commands));
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Properties laden(String verzeichnis) {
		Properties daten=new Properties();
		Serialisieren ser=new Serialisieren();
		daten=ser.laden(verzeichnis);
		
		prototypen=(Vector<Prototyp>) daten.get("Zentralverwaltung");
		commands=(Vector<Command>) daten.get("Zentralverwaltung");
		
		return null;
	}

	@Override
	public void speichern(Properties daten, String verzeichnis) {
		daten=new Properties();
		daten.put("Zentralverwaltung", prototypen);
		daten.put("Zentralverwaltung", commands);
		Serialisieren ser=new Serialisieren();
		ser.speichern(daten, verzeichnis);
	
	}	
	
}
