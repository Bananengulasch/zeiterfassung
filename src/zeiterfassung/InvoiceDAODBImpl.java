package zeiterfassung;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InvoiceDAODBImpl implements InvoiceDAO {
	Connection myConn = null;
	Statement myStmt = null;
	ResultSet myRs = null;
	
	
	public static Connection connect() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/apr", "root" , "");
	}
	
	public void addInvoice(String server_name, String server_nachricht, Timestamp server_zeit) {
		PreparedStatement myStmt = null;
		Connection myConn = null;
		ResultSet myRs = null;
		String statement = "INSERT INTO autohaus (marke, modell, aufbau, jahr, kilometer, ps,  nwgw, tueren, farbe, getriebe, preis, verkauft) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			// 1. Get a connection to database
			myConn = connect();
			
			// 2. Create a statement
			myStmt = myConn.prepareStatement(statement);
			myStmt.setString(1, marke);
			myStmt.setString(2, modell);
			myStmt.setString(3, aufbau);
			myStmt.setInt(4, jahr);
			myStmt.setInt(5, kilometer);
			myStmt.setInt(6, ps);
			myStmt.setString(7, nwgw);
			myStmt.setInt(8, tueren);
			myStmt.setString(9, farbe);
			myStmt.setString(10, getriebe);
			myStmt.setInt(11, preis);
			myStmt.setString(12, verkauft);
			myStmt.execute();
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		finally {
			if (myRs != null) {
				try {
					myRs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if (myStmt != null) {
				try {
					myStmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if (myConn != null) {
				try {
					myConn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}