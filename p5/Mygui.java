/**
 * Putra Sudaryanto
 * 12111075
 * 22/TI
 **/

import javax.swing.*;
import java.awt.*;

class Mygui extends JFrame {
	public Mygui() {
		render();
	}

	public void render() {
		JPanel prop = new JPanel();
      	prop.setLayout(null);
		
      	prop.add(new JLabel("NIM")).setBounds(10, 10, 100, 25);
      	prop.add(new JLabel(": 12111075")).setBounds(100, 10, 200, 25);

      	prop.add(new JLabel("Nama")).setBounds(10, 40, 100, 25);
      	prop.add(new JLabel(": Dwi Putra Sudaryanto")).setBounds(100, 40, 200, 25);

      	prop.add(new JLabel("E-Learning (Identity)")).setBounds(120, 80, 200, 25);

      	prop.add(new JLabel("SIN")).setBounds(10, 120, 100, 25);
      	prop.add(new JTextField(8)).setBounds(100, 120, 150, 25);

      	prop.add(new JLabel("Name")).setBounds(10, 150, 100, 25);
      	prop.add(new JTextField(64)).setBounds(100, 150, 200, 25);

      	prop.add(new JLabel("Address")).setBounds(10, 180, 100, 25);
      	prop.add(new JTextField(128)).setBounds(100, 180, 280, 25);

      	prop.add(new JLabel("Gender")).setBounds(10, 210, 100, 25);
      	JRadioButton male = new JRadioButton("Male");
      	JRadioButton female = new JRadioButton("Female");
      	ButtonGroup gender = new ButtonGroup();
      	prop.add(male).setBounds(100, 210, 70, 25);
      	prop.add(female).setBounds(180, 210, 70, 25);
      	gender.add(male);
      	gender.add(female);
      	
      	String[] list_agama = {"Islamic","Katholic","Christian","Budhis","Hindu","Konghucu"};
      	prop.add(new JLabel("Religion")).setBounds(10, 240, 100, 25);
      	JComboBox opt_agama = new JComboBox(list_agama);
      	prop.add(opt_agama).setBounds(100, 240, 150, 25);

      	prop.add(new JLabel("E-Mail")).setBounds(10, 270, 100, 25);
      	prop.add(new JTextField(64)).setBounds(100, 270, 200, 25);

      	prop.add(new JLabel("Facebook")).setBounds(10, 300, 100, 25);
      	prop.add(new JTextField(64)).setBounds(100, 300, 200, 25);
      	
      	prop.add(new JLabel("Phone")).setBounds(10, 330, 100, 25);
      	prop.add(new JTextField(32)).setBounds(100, 330, 200, 25);

      	prop.add(new JButton("Save")).setBounds(100, 370, 70, 25);
      	prop.add(new JButton("Edit")).setBounds(175, 370, 70, 25);
		prop.add(new JButton("Exit")).setBounds(250, 370, 70, 25);
		
      	this.setContentPane(prop);
		setTitle("Frame");
		setLocation(300,100);
		setSize(400,500);		
	}

	public static void main(String[]args) {
		Mygui f = new Mygui();
		f.setVisible(true);
	}
}
