/**
 * Putra Sudaryanto
 * 12111075
 * 22/TI
 **/

import javax.swing.*;
import java.awt.event.*;

class Myform extends JFrame {	
	JTextField sinField = new JTextField(8);
	JTextField nameField = new JTextField(32);
	JTextField addressField = new JTextField(128);
	JTextField emailField = new JTextField(32);
	JTextField facebookField = new JTextField(64);
	JTextField phoneField = new JTextField(15);
	
	JRadioButton male = new JRadioButton("Male");
	JRadioButton female = new JRadioButton("Female");
	ButtonGroup gender = new ButtonGroup();	
	
	String[] list_agama = {"","Islamic","Katholic","Christian","Budhis","Hindu","Konghucu"};
	JComboBox opt_agama = new JComboBox(list_agama);
	
	JCheckBox watch_tv = new JCheckBox("Watch TV");
	JCheckBox sleeping = new JCheckBox("Sleeping");
	
	JTextArea textView = new JTextArea();
	JButton buttonSave = new JButton("SAVE");
	JButton buttonExit = new JButton("EXIT");
	
	public Myform() {
		setTitle("Form Data Mahasiswa");
		setLocation(320,120);
		setSize(720,530);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void render() {
		/* Form */
		JPanel prop = new JPanel();
      	prop.setLayout(null);
		
      	prop.add(new JLabel("NIM")).setBounds(10, 10, 100, 25);
      	prop.add(new JLabel(": 12111075")).setBounds(100, 10, 200, 25);

      	prop.add(new JLabel("Nama")).setBounds(10, 40, 100, 25);
      	prop.add(new JLabel(": Dwi Putra Sudaryanto")).setBounds(100, 40, 200, 25);

      	prop.add(new JLabel("E-Learning (Identity)")).setBounds(120, 80, 200, 25);

      	prop.add(new JLabel("SIN")).setBounds(10, 120, 100, 25);
      	prop.add(sinField).setBounds(100, 120, 150, 25);

      	prop.add(new JLabel("Name")).setBounds(10, 150, 100, 25);
      	prop.add(nameField).setBounds(100, 150, 200, 25);

      	prop.add(new JLabel("Address")).setBounds(10, 180, 100, 25);
      	prop.add(addressField).setBounds(100, 180, 280, 25);

      	prop.add(new JLabel("Gender")).setBounds(10, 210, 100, 25);
      	prop.add(male).setBounds(100, 210, 70, 25);
      	prop.add(female).setBounds(180, 210, 70, 25);
      	gender.add(male);
      	gender.add(female);      	
      	
      	prop.add(new JLabel("Religion")).setBounds(10, 240, 100, 25);
      	prop.add(opt_agama).setBounds(100, 240, 150, 25);		

      	prop.add(new JLabel("Hobby")).setBounds(10, 270, 100, 25);
      	prop.add(watch_tv).setBounds(100, 270, 200, 25);
      	prop.add(sleeping).setBounds(100, 290, 200, 25);

      	prop.add(new JLabel("E-Mail")).setBounds(10, 320, 100, 25);
      	prop.add(emailField).setBounds(100, 320, 200, 25);

      	prop.add(new JLabel("Facebook")).setBounds(10, 350, 100, 25);
      	prop.add(facebookField).setBounds(100, 350, 200, 25);
      	
      	prop.add(new JLabel("Phone")).setBounds(10, 380, 100, 25);
      	prop.add(phoneField).setBounds(100, 380, 200, 25);

		prop.add(textView).setBounds(400, 10, 250, 300);
      	prop.add(buttonSave).setBounds(100, 410, 70, 25);
		prop.add(buttonExit).setBounds(180, 410, 70, 25);
		
      	this.setContentPane(prop);
		setVisible(true);
	}
	
	public void event() {
		buttonSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textView.setText("");
				textView.append(sinField.getText()+"\n");
				textView.append(nameField.getText()+"\n");
				textView.append(addressField.getText()+"\n");
				
				if(male.isSelected() != true && female.isSelected() != true) {
					textView.append("gender cannot be blank\n");
				} else {
					if(male.isSelected() == true){
						textView.append(male.getText()+"\n");
					} else {
						textView.append(female.getText()+"\n");
					}
					
				}
				
				textView.append(opt_agama.getSelectedItem().toString()+"\n");
				
				if((watch_tv.isSelected() == true) && (sleeping.isSelected() == true)){
					textView.append(watch_tv.getText() +", "+ sleeping.getText()+"\n");
				} 
				else if(sleeping.isSelected() == true){
					textView.append(sleeping.getText()+"\n");
				}
				else if(watch_tv.isSelected() == true){
					textView.append(watch_tv.getText()+"\n");
				}
				
				textView.append(emailField.getText()+"\n");
				textView.append(facebookField.getText()+"\n");
				textView.append(phoneField.getText()+"\n");
			}
		});
		
		buttonExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
	}

	public static void main(String[]args) {
		Myform f = new Myform();
		f.render();
		f.event();
	}
}
