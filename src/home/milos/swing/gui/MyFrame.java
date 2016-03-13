package home.milos.swing.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ComboBoxEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MyFrame extends JFrame{
	
	private JLabel label1;
	private JTextField t1;
	private JButton button;
	private JComboBox<String> combo;

	
	public MyFrame() {
		initFrame();
		
		label1=new JLabel("Hello World");
		t1=new JTextField();
		
		createButton();
		
		combo=new JComboBox<String>(new String[]{"Pera","Zika","Mika"});
		combo.setSelectedItem("Zika");
		
		GridLayout experimentLayout = new GridLayout(0,2);
		getContentPane().setLayout(experimentLayout);
		
		getContentPane().add(label1);
		getContentPane().add(t1);
		getContentPane().add(button);
		
		getContentPane().add(combo);
		
		getContentPane().validate();
		
	}



	private void createButton() {
		button=new JButton("Click me");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String msg=label1.getText() + combo.getSelectedItem() + t1.getText();
				createDialog(msg);
				
			}
		});
	}



	private void initFrame() {
		setVisible(true);
		setSize(250, 250);
		setLocationRelativeTo(null);
		setTitle("Ovo je moj frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}



	private void createDialog(String msg) {
		JDialog jd=new JDialog(MyFrame.this, msg, false);
		jd.setVisible(true);
		jd.setSize(200, 200);
		jd.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}

}
