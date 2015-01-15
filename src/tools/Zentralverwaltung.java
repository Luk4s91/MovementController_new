package tools;
import java.util.Properties;
import java.util.Vector;

import model.Command;
import model.Prototyp;


public class Zentralverwaltung implements Interface{
	private Vector <Prototyp> prototypen = new Vector <Prototyp>();    //Es soll von jedem Vektor nur einen geben.

	private Vector <Command> controllprocess = new Vector <Command>();
	
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
		return controllprocess;
	}
	public Prototyp vPrototypenObject(int iD){
		return prototypen.elementAt(iD);
	}
	public String vPrototypenToString(){
		return prototypen.toString();
	}
	public String vControllProcessToString(){
		return controllprocess.toString();
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
		controllprocess.addElement(prototyp.createInstance()); //Fuegt vom ausgewaehlten Prototyp ein Command-Objekt ein.
	}
	public void removeStep(int iD)
	{
		if(controllprocess.size()>iD){
		controllprocess.remove(iD);
		}
	}
	public void incOrder(int iD)
	{
		if(!controllprocess.firstElement().equals(controllprocess.elementAt(iD)))
		{
		controllprocess.addElement(controllprocess.elementAt(iD-1)); //Temp in Vektorliste
//		System.out.println("1: " + controllprocess);
		controllprocess.setElementAt(controllprocess.elementAt(iD), iD-1);
//		System.out.println("2: " + controllprocess);
		controllprocess.setElementAt(controllprocess.lastElement(), iD);
//		System.out.println("3: " + controllprocess);
		controllprocess.removeElementAt(controllprocess.size()-1);
		//controllprocess.removeElementAt(controllprocess.lastIndexOf(controllprocess)+1);
		}
	}
	public void decOrder(int iD)
	{
		if(!controllprocess.lastElement().equals(controllprocess.elementAt(iD)))
		{
		controllprocess.addElement(controllprocess.elementAt(iD+1)); //Temp in Vektorliste
		controllprocess.setElementAt(controllprocess.elementAt(iD), iD+1);
		controllprocess.setElementAt(controllprocess.lastElement(), iD);
		controllprocess.removeElementAt(controllprocess.size()-1);
		//controllprocess.removeElementAt(controllprocess.lastIndexOf(controllprocess));
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Properties laden(String verzeichnis) {
		Properties daten=new Properties();
		Serialisieren ser=new Serialisieren();
		daten=ser.laden(verzeichnis);
		
		prototypen=(Vector<Prototyp>) daten.get("Zentralverwaltung");
		controllprocess=(Vector<Command>) daten.get("Zentralverwaltung");
		
		return null;
	}

	@Override
	public void speichern(Properties daten, String verzeichnis) {
		daten=new Properties();
		daten.put("Zentralverwaltung", prototypen);
		daten.put("Zentralverwaltung", controllprocess);
		Serialisieren ser=new Serialisieren();
		ser.speichern(daten, verzeichnis);
	
	}	
	
}
