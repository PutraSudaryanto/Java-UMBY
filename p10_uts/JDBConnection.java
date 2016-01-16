import java.sql.*;

class JDBConnection {
	 //Class.forName("com.mysql.jdbc.Driver");

	private static final String database = "_kampus_java_crud";
	private static final String url = "jdbc:mysql://localhost/"+database;
	private static final String user = "root";
	private static final String password = "root";

	public Connection getConnection()  {
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, user, password);
            System.out.println("========================================");
            System.out.println("JDBC & MySQL successfully connected");
            System.out.println("Nama : Dwi Putra Sudaryanto");
            System.out.println("NIM : 12111075");
            System.out.println("Kelas : 22");
            System.out.println("Prodi : Teknik Informasi");
            System.out.println("========================================");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public static void main(String[] args) {
		JDBConnection c = new JDBConnection();
		c.getConnection();		
	}
}
