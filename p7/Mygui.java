/**
 * Putra Sudaryanto
 * 12111075
 * 22/TI
 **/

import javax.swing.*;
import java.awt.event.*;

class Mygui extends JFrame {
	/* Mainmenu and Submenu */
	JMenuBar mainmenu = new JMenuBar();
	
	JMenu menu_file = new JMenu("File");
	JMenuItem submenu_exit = new JMenuItem("Exit");
	
	JMenu menu_data = new JMenu("Data");
	JMenuItem submenu_mhs = new JMenuItem("Data Mahasiswa");
	
	JMenu menu_about = new JMenu("About");
	JMenuItem submenu_about = new JMenuItem("About Us");

	Myform getForm = new Myform();
	
	public Mygui() {
		setTitle("Putra Sudaryanto | 12111075");
		setLocation(300,100);
		setSize(420,250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void render() {
		/* Set Mainmenu and Submenu */
		setJMenuBar(mainmenu);
		mainmenu.add(menu_file);
		menu_file.add(submenu_exit);
		mainmenu.add(menu_data);
		menu_data.add(submenu_mhs);
		mainmenu.add(menu_about);
		menu_about.add(submenu_about);
		
		setVisible(true);
	}
	
	public void event() {		
		submenu_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		submenu_mhs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getForm.render();
				getForm.event();
			}
		});
		
		submenu_about.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "<html>Powered by Putra Sudaryanto<br/><a href='http://www.putra.ommu.co'>www.putra.ommu.co</a></html>","About",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
	}

	public static void main(String[]args) {
		Mygui g = new Mygui();
		g.render();
		g.event();
	}
}
