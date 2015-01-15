package view;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.SplitPaneUI;
import javax.swing.plaf.basic.BasicBorders.SplitPaneBorder;

import model.Command;
import model.Gear;
import model.Goto;
import model.Prototyp;
import tools.Zentralverwaltung;


public class View extends JFrame {

	private Zentralverwaltung zentral;
	
	public View(Zentralverwaltung zentral) {
		super("Zentralverwaltung");                  
		this.zentral = zentral;
		
//WINDOW
		setTitle("Control-Developer");
	    setLayout( new BorderLayout() );
	    setSize(1000, 600);
	    
//MENUBAR
	    JMenuBar menu = new JMenuBar( );
	    setJMenuBar(menu);	    
	    JMenu dataMenu = new JMenu("Data");
        menu.add(dataMenu);
        JMenuItem openEntry = new JMenuItem("Open");
        dataMenu.add(openEntry);
        JMenuItem exitEntry = new JMenuItem("Exit");
        dataMenu.add(exitEntry);
        JMenu helpMenu = new JMenu("Help");
        menu.add(helpMenu);
        JMenuItem infoEntry = new JMenuItem("Info");
        helpMenu.add(infoEntry);
        
//FRAME	    
	    JPanel southPanel = new JPanel();
	    JPanel westPanel = new JPanel();
	    JPanel eastPanel = new JPanel();
	    JPanel centerPanel = new JPanel();
	    
	    add( southPanel, BorderLayout.SOUTH );    
	    add( westPanel, BorderLayout.WEST );    
	    add( eastPanel, BorderLayout.EAST );    
	    add( centerPanel, BorderLayout.CENTER );  
	    
	    southPanel.setBorder(BorderFactory.createLoweredBevelBorder());
	    westPanel.setBorder(BorderFactory.createLoweredSoftBevelBorder());
	    eastPanel.setBorder(BorderFactory.createLoweredSoftBevelBorder());
	    centerPanel.setBorder(BorderFactory.createLoweredSoftBevelBorder());
	    
//WEST  
	    westPanel.setLayout(new BorderLayout());
	    JLabel prototypLabel = new JLabel("Prototypes");
	    westPanel.add(prototypLabel, BorderLayout.NORTH);
	    
	    JList<Prototyp> prototypList = new JList<Prototyp>(zentral.getPrototypen());   //prototypList
	    westPanel.add(prototypList, BorderLayout.CENTER);
	    
	    JButton addButton = new JButton("Add");
	    westPanel.add(addButton, BorderLayout.SOUTH);
	    
//CENTER	    
	    centerPanel.setLayout(new BorderLayout());
	    
	    JLabel commandLabel = new JLabel("Commands");
	    centerPanel.add(commandLabel, BorderLayout.NORTH);
	    
	    JList<Command> commandList = new JList<Command>(zentral.getCommand());   //commandList
	    centerPanel.add(commandList, BorderLayout.CENTER);
	    centerPanel.add(new JScrollPane(commandList), BorderLayout.CENTER);
	    
	    
//	    JScrollBar scrollbar = new JScrollBar(JScrollBar.VERTICAL);              
//	    centerPanel.add(scrollbar, BorderLayout.EAST);
        
	    
	    JButton removeButton = new JButton("Remove");
	    JButton upButton = new JButton("Up");
	    JButton downButton = new JButton("Down");
	    JButton startButton = new JButton("Start");
	    JLabel clearLabel0 = new JLabel("");
	    JLabel clearLabel1 = new JLabel("");
	    
	    JPanel centerButtomPanel = new JPanel();
	    centerButtomPanel.setLayout(new GridLayout());
	    centerButtomPanel.add(removeButton);
	    centerButtomPanel.add(clearLabel0);
	    centerButtomPanel.add(clearLabel1);
	    centerButtomPanel.add(upButton);
	    centerButtomPanel.add(downButton);
	    centerButtomPanel.add(startButton);
	    
	    centerPanel.add(centerButtomPanel, BorderLayout.SOUTH);
	    
//EAST
	    eastPanel.setLayout(new BorderLayout());
	    
	    JLabel configLabel = new JLabel ("Configuration");
	    eastPanel.add(configLabel, BorderLayout.NORTH);
	    	       	    	    
	    JButton saveButton = new JButton("Save");
	    eastPanel.add(saveButton, BorderLayout.SOUTH);
	   
	    JPanel configPanel = new JPanel();
	    configPanel.setLayout(new GridLayout(6,1));
	    eastPanel.add(configPanel);	    
	    
//Gear	    
	    JTextField speedValue = new JTextField();
	    JTextField speed = new JTextField("Speed");
	    speed.setEditable(false);
	    
	    JTextField durationValue = new JTextField();
	    JTextField duration = new JTextField("Duration");
	    duration.setEditable(false);	  
	    
//Direction	    
	    JTextField degreeValue = new JTextField();
	    JTextField degree = new JTextField("Degree");
	    degree.setEditable(false);
	    
//Goto
	    JTextField jumpAdressValue = new JTextField();
	    JTextField jumpAdress = new JTextField("jumpAdress");
	    jumpAdress.setEditable(false);
	    
//If
	    JTextField referenceValue = new JTextField();
	    JTextField reference = new JTextField("reference");
	    reference.setEditable(false);	    
	    
//SOUTH
	    JTextArea output = new JTextArea("Ausgabefenster",8,75); 
	    output.setEditable(false);
	    southPanel.add(output);
	    southPanel.add(new JScrollPane(output), BorderLayout.SOUTH);
	    
	    
//ACTIONLISTENER	    
        addButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (prototypList.isSelectionEmpty()){
					output.setText("Fehler: Kein Prototyp ausgewaehlt.");
				}else{
					commandList.updateUI();
					zentral.addStep(prototypList.getSelectedValue());
				}

			}
		});

        upButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (commandList.isSelectionEmpty()){
					output.setText("Fehler: Kein Command ausgewaehlt.");
				}else{
					commandList.updateUI();
					zentral.incOrder(commandList.getSelectedIndex());
				}

			}
		});

        downButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (commandList.isSelectionEmpty()){
					output.setText("Fehler: Kein Command ausgewaehlt.");
				}else{
					commandList.updateUI();
					zentral.decOrder(commandList.getSelectedIndex());
				}

			}
		});
        
        removeButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (commandList.isSelectionEmpty()){
					output.setText("Fehler: Kein Command ausgewaehlt.");
				}else{
					commandList.updateUI();
					zentral.removeStep(commandList.getSelectedIndex());
				}

			}
		});
	    
        commandList.addListSelectionListener(new SelectionListener(){
        	public void valueChanged(ListSelectionEvent e) {
        		
        		if(commandList.getSelectedValue().getCommandName() =="Gear"){
        			Gear gear = (Gear)zentral.getCommand().get(commandList.getSelectedIndex());
        			
        			configPanel.updateUI();
        			configPanel.removeAll();
        			
            		configPanel.add(speed);
            		speedValue.setText(gear.getSpeedAsString());
            		configPanel.add(speedValue);
            		
            		configPanel.add(duration);
            		durationValue.setText(gear.getDurationAsString());
            		configPanel.add(durationValue);
            		          		
        		}else if(commandList.getSelectedValue().getCommandName() =="Goto"){
        			Goto gotox = (Goto)zentral.getCommand().get(commandList.getSelectedIndex());
        			
        			configPanel.updateUI();
        			configPanel.removeAll();
        			
            		configPanel.add(jumpAdress);
            		jumpAdressValue.setText(gotox.getJumpAdressAsString());
            		configPanel.add(jumpAdressValue);
            		
        		}
        		
        	}
        });

	}
	
	public static void main(String[] args){

	Zentralverwaltung zentral = Zentralverwaltung.createInstance();
	zentral.createPrototypes();
	
	View view = new View(zentral);
	view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//view.pack();
	view.setVisible(true);
	//ENDE
	}

}
