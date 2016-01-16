/**
 * Putra Sudaryanto
 * 12111075
 * 22/TI
 **/

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class ZoneProvince extends JFrame {	
	/* Mainmenu and Submenu */
	JMenuBar mainmenu = new JMenuBar();
	JMenu menu_data = new JMenu("Data");
	JMenuItem submenu_insert = new JMenuItem("Tambah");
	JMenuItem submenu_update = new JMenuItem("Perbarui");
	JMenuItem submenu_delete = new JMenuItem("Hapus");

	String[] tableHeader = {"Provinsi","MFD Online"};
	
	JLabel mfdLabel = new JLabel("MFD Online");
	JLabel provinceLabel = new JLabel("Provinsi");
	
	JTextField mfdField = new JTextField(2);	
	JTextField provinceField = new JTextField(64);
	
	JButton buttonInsert = new JButton("Tambah");
	JButton buttonUpdate = new JButton("Perbarui");
	JButton buttonSearch = new JButton("Cari");
	JButton buttonDelete = new JButton("Hapus");
	JButton buttonExit = new JButton("Exit");
	
	JPanel prop = new JPanel();
	JTable table = new JTable();
	JScrollPane scroll = new JScrollPane();
	private Object[][] tableData = null;
	
	void ZoneView() {
		setJMenuBar(mainmenu);
		
		mainmenu.add(menu_data);
		menu_data.add(submenu_insert);
		menu_data.add(submenu_update);
		menu_data.add(submenu_delete);
		
		JDBConnection open = new JDBConnection ();
		Connection mysql = open.getConnection();
		
		try {
			Statement stmt = mysql.createStatement();
			String sql = "SELECT `province`, `mfdonline` FROM `ommu_core_zone_province`";
	        
	        ResultSet results = stmt.executeQuery(sql);
	        ResultSetMetaData meta = results.getMetaData();
	        int field = meta.getColumnCount(),
	        	rows = 0;

	        while(results.next())
	        {
	        	rows = results.getRow();
	        }
	        tableData = new Object[rows][field];
	        int i = 0;
	        results.beforeFirst();
	        while(results.next())
	        {
	        	tableData[i][0] = results.getString("province");
	        	tableData[i][1] = results.getString("mfdonline");
	        	i++;
	        }
	        scroll.setViewportView(table);
	        table.setModel(new DefaultTableModel(tableData, tableHeader));
			add(scroll, BorderLayout.NORTH);
	        stmt.close();
	        results.close();
			
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Data Provinsi Error");
		}

		setTitle("Data Provinsi");
        setLocation(300,120);
        setSize(800, 500);
		setVisible(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}
	
	void ZoneInsert() {
      	prop.setLayout(null);

      	prop.add(mfdLabel).setBounds(10, 10, 100, 25);
      	prop.add(mfdField).setBounds(100, 10, 100, 25);

      	prop.add(provinceLabel).setBounds(10, 40, 100, 25);
      	prop.add(provinceField).setBounds(100, 40, 250, 25);
		
      	prop.add(buttonInsert).setBounds(100, 70, 100, 25);
		prop.add(buttonExit).setBounds(210, 70, 100, 25);
		
      	this.setContentPane(prop);

		setTitle("Tambah Data Provinsi");
        setLocation(300,120);
        setSize(390,250);
		setVisible(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}
	
	void ZoneUpdate() {
      	prop.setLayout(null);

      	prop.add(mfdLabel).setBounds(10, 10, 100, 25);
      	prop.add(mfdField).setBounds(100, 10, 100, 25);
		prop.add(buttonSearch).setBounds(210, 10, 100, 25);

      	prop.add(provinceLabel).setBounds(10, 40, 100, 25);
      	prop.add(provinceField).setBounds(100, 40, 250, 25);
		
      	prop.add(buttonUpdate).setBounds(100, 70, 100, 25);
		prop.add(buttonExit).setBounds(210, 70, 100, 25);
		
      	this.setContentPane(prop);

		setTitle("Perbarui Data Provinsi");
        setLocation(300,120);
        setSize(390,250);
		setVisible(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}
	
	void ZoneDelete() {
      	prop.setLayout(null);

      	prop.add(mfdLabel).setBounds(10, 10, 100, 25);
      	prop.add(mfdField).setBounds(100, 10, 100, 25);
		
      	prop.add(buttonDelete).setBounds(100, 40, 100, 25);
		prop.add(buttonExit).setBounds(210, 40, 100, 25);
		
      	this.setContentPane(prop);

		setTitle("Hapus Data Provinsi");
        setLocation(300,120);
        setSize(390,250);
		setVisible(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}
	
	public void event() {
		submenu_insert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ZoneProvince v = new ZoneProvince();
				v.ZoneInsert();
				v.event();
			}
		});
		
		submenu_update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ZoneProvince v = new ZoneProvince();
				v.ZoneUpdate();
				v.event();
			}
		});
		
		submenu_delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ZoneProvince v = new ZoneProvince();
				v.ZoneDelete();
				v.event();
			}
		});
		
		buttonExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		buttonInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String province, mfdonline;
				mfdonline = mfdField.getText();
				province = provinceField.getText();
				
				JDBConnection open = new JDBConnection ();
				Connection mysql = open.getConnection();
				try {
					Statement stmt = mysql.createStatement();
					String sql = "INSERT INTO `ommu_core_zone_province` (`province`, `mfdonline`) VALUES ('"+province+"', '"+mfdonline+"');";
					int i = stmt.executeUpdate(sql);
					if (i == 1) {
						JOptionPane.showMessageDialog(null, "Provinsi berhasil ditambahkan");
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
			}
		});
		
		buttonSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String search, province, mfdonline;
				
				JDBConnection open = new JDBConnection ();
				Connection mysql = open.getConnection();
				try {
					search = mfdField.getText();
					Statement stmt = mysql.createStatement();
					String sql = "SELECT `province`, `mfdonline` FROM `ommu_core_zone_province` WHERE `mfdonline`='"+search+"'";
					
					ResultSet i = stmt.executeQuery(sql);
					if(i.next()) {
						provinceField.setText(i.getString(1));
						mfdField.setText(i.getString(2));
					} else {
						JOptionPane.showMessageDialog(null, "Provinsi tidak ditemukan");
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}				
			}
		});
		
		buttonUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String province, mfdonline;
				province = provinceField.getText();
				mfdonline = mfdField.getText();
				
				JDBConnection open = new JDBConnection ();
				Connection mysql = open.getConnection();
				try {
					Statement stmt = mysql.createStatement();
					String sql = "UPDATE `ommu_core_zone_province` SET `province`='"+province+"', `mfdonline`='"+mfdonline+"' WHERE `mfdonline`='"+mfdonline+"'";
					
					int i = stmt.executeUpdate(sql);
					if (i == 1) {
						JOptionPane.showMessageDialog(null, "Provinsi berhasil diperbarui");
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}				
			}
		});
		
		buttonDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mfdonline;
				mfdonline = mfdField.getText();
				
				JDBConnection open = new JDBConnection ();
				Connection mysql = open.getConnection();
				try {
					Statement stmt = mysql.createStatement();
					String sql = "DELETE FROM `ommu_core_zone_province` WHERE `mfdonline`='"+mfdonline+"'";
					
					int i = stmt.executeUpdate(sql);
					if (i == 1) {
						JOptionPane.showMessageDialog(null, "Provinsi berhasil dihapus");
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}				
			}
		});
	}

	public static void main(String[]args) {
		ZoneProvince v = new ZoneProvince();
		v.ZoneView();
		v.event();
	}
}
