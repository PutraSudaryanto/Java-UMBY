/**
 * Putra Sudaryanto
 * 12111075
 * 22/TI
 **/
 
import javax.swing.*;
import java.awt.event.*;

import java.io.*;
import java.sql.*;


class ZoneFront extends JFrame {
	/* Mainmenu and Submenu */
	JMenuBar mainmenu = new JMenuBar();
	
	JMenu menu_file = new JMenu("File");
	JMenuItem submenu_install = new JMenuItem("Install");
	JMenuItem submenu_exit = new JMenuItem("Exit");
	
	JMenu menu_data = new JMenu("Data");
	JMenuItem submenu_province = new JMenuItem("Provinsi");
	JMenuItem submenu_city = new JMenuItem("Kabupaten, Kota");
	JMenuItem submenu_district = new JMenuItem("Kecamatan");
	JMenuItem submenu_village = new JMenuItem("Desa");
	
	JMenu menu_about = new JMenu("About");
	JMenuItem submenu_about = new JMenuItem("About Us");
	
	public ZoneFront() {
		setTitle("Database Wilayah Indonesia");
		setLocation(300,100);
		setSize(420,250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void render() {
		/* Set Mainmenu and Submenu */
		setJMenuBar(mainmenu);
		
		mainmenu.add(menu_file);
		menu_file.add(submenu_install);
		menu_file.add(submenu_exit);
		
		mainmenu.add(menu_data);
		menu_data.add(submenu_province);
		menu_data.add(submenu_city);
		menu_data.add(submenu_district);
		menu_data.add(submenu_village);
		
		mainmenu.add(menu_about);
		menu_about.add(submenu_about);
		
		setVisible(true);
	}
	
	public void event() {
		// menu.File
		/*
		submenu_install.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JDBConnection open = new JDBConnection ();
				Connection mysql = open.getConnection();
				try {
					Statement stmt = mysql.createStatement();
					String sql = "CREATE TABLE Table_Pegawai"+"(NIP char(10),"+
					"Name varchar(40),"+
					"TTL varchar(40),"+"Address varchar(45)," +
					"Gender varchar(6), " +"Golongan varchar(20))";
					stmt.executeUpdate(sql);
					stmt.close();
					JOptionPane.showMessageDialog(null, "Install Success");
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
			}
		});
		*/
		
		// menu.Provinsi
		submenu_province.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ZoneProvince v = new ZoneProvince();
				v.ZoneView();
				v.event();
			}
		});
		submenu_city.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ZoneCity v = new ZoneCity();
				v.ZoneView();
				v.event();
			}
		});
		submenu_district.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ZoneDistrict v = new ZoneDistrict();
				v.ZoneView();
				v.event();
			}
		});
		submenu_village.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ZoneVillage v = new ZoneVillage();
				v.ZoneView();
				v.event();
			}
		});
		
		submenu_about.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "<html>Powered by Putra Sudaryanto<br/><a href='http://www.putra.ommu.co'>www.putra.ommu.co</a></html>","About",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		submenu_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
	}

	public static void main(String[]args) {
		ZoneFront v = new ZoneFront();
		v.render();
		v.event();
	}
}
