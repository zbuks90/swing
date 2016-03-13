package home.milos.swing.gui.home;

import java.awt.Choice;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Enumeration;
import java.util.Iterator;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class StudentLogIn extends JFrame{

	private JLabel label1;
	private JTextField t1;
	private JLabel label2;
	private JTextField t2;
	private JLabel label3;
	private JTextField t3;
	private JLabel label4;
	private JComboBox<String> combo;
	private JRadioButton male;
    private JRadioButton female;
    private JButton button;
    private ButtonGroup bg;
    private JList<String> l1;
    
	
	public StudentLogIn() {
		initFrame();
		
		label1=new JLabel("Ime i Prezime:");
		t1=new JTextField();
		label2=new JLabel("Maticni broj:");
		t2=new JTextField();
		label3=new JLabel("Datum:");
		t3=new JTextField();
		label4=new JLabel("Smer:");
		combo=new JComboBox<String>(new String[]{"ISIT","Menadžment","Upravljanje kvalitetom"});
		combo.setSelectedItem("ISIT");
		
		male = new JRadioButton("male");
		female = new JRadioButton("Female");
			
		bg=new ButtonGroup(); 
		bg.add(male);
		bg.add(female);
		male.setSelected(true);
		
		
		
		createButton();
		
		GridLayout experimentLayout = new GridLayout(0,2);
		getContentPane().setLayout(experimentLayout);
		
		getContentPane().add(label1);
		getContentPane().add(t1);
		
		getContentPane().add(label2);
		getContentPane().add(t2);
		
		getContentPane().add(label3);
		getContentPane().add(t3);
		
		getContentPane().add(label4);
		getContentPane().add(combo);
		
		getContentPane().add(male);
		getContentPane().add(female);
		
		getContentPane().add(button);
		
		String[] queue=new String[3];
		queue[0] = "Record";
		queue[1] = "Pera";
		queue[2] = "Zika";
		
		l1=new JList<>(queue);
		getContentPane().add(l1);
		
		JMenuBar mb=new JMenuBar();
		//Build the first menu.
		JMenu menu = new JMenu("A Menu");
		JMenuItem item1=new JMenuItem("FileNew");
		item1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Click on FileNew");
			}
		});
		
		JCheckBoxMenuItem item2=new JCheckBoxMenuItem("Check me pls!!!");
		menu.add(item2);
		menu.add(item1);
		
		JMenu submenu = new JMenu("A Submenu");
		submenu.add(new JMenuItem("test 1"));
		submenu.add(new JMenuItem("test 2"));
		menu.add(submenu);
		mb.add(menu);
		mb.setVisible(true);
		mb.validate();
		setJMenuBar(mb);
		
		
		getContentPane().validate();
	}

	
	private void createButton() {
		button=new JButton("Record");
		button.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					String str = label1.getText() + " " + t1.getText() + " " + label2.getText() + " " + t2.getText()
							+ " " + label3.getText() + " " + t3.getText() + " " + label4.getText() + " "
							+ combo.getSelectedItem() + " " + getSelectedButtonName() + " " + getSelectedListItems();
		            File newTextFile = new File("D:/java obuka/eclipse/student.txt");

		            FileWriter fw = new FileWriter(newTextFile);
		            fw.write(str);
		            fw.close();
		            //setDefaultCloseOperation(EXIT_ON_CLOSE);
		            
		            

		        } catch (IOException iox) {
		            //do stuff with exception
		            iox.printStackTrace();
		        }
				
				
			
			}

			
		});
	}

	protected String getSelectedListItems() {
		
		return null;
	}


	protected String getSelectedButtonName() {
		
		
		for (Enumeration<AbstractButton> buttons = bg.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }
		return null;
	}


	private void initFrame() {
		setVisible(true);
		setSize(350, 350);
		setLocationRelativeTo(null);
		setTitle("Log In");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		
	}
	
    
}
