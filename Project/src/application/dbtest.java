package application;
import java.sql.*;

public class dbtest {
	public static void main(String[] args) {
		System.out.println("Processing...");
		//update();
	}
	public static void update(String a, String b, String c, String d) {
		Connection con=null;
		Statement stmt=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
			final String USER = "root";
			final String PASS = "";
			final String DB_URL = "jdbc:mysql://127.0.0.1:3306/javaproj";
			con = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = con.createStatement();
			//_carPark cp = new _carPark();
			//String SPOT = cp.getSpot();
			String SPOT = a;
			String NAME = c;
			String NUMP = d;
 			System.out.println(SPOT);
 			if(b=="car") {
 				String sql = "INSERT INTO cspot VALUES('"+SPOT+"', '"+NAME+"', '"+NUMP+"', 'TIME')";
 				stmt.executeUpdate(sql);
 				ResultSet rs = stmt.executeQuery("SELECT * FROM cspot");
 				while(rs.next()) {	
 					System.out.println(rs.getString(1));	
 				}
 			}else if(b=="bike") {
 				String sql = "INSERT INTO bspot VALUES('"+SPOT+"', '"+NAME+"', '"+NUMP+"', 'TIME')";
 				stmt.executeUpdate(sql);
 				ResultSet rs = stmt.executeQuery("SELECT * FROM bspot");
 				while(rs.next()) {	
 					System.out.println(rs.getString(1));	
 				}
 			}
		}catch(SQLException se) {
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}