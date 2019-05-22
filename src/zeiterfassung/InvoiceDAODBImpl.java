package zeiterfassung;

import java.sql.*;
import java.sql.Date;
import java.util.*;
public class InvoiceDAODBImpl implements InvoiceDAO {
	Connection myConn = null;
	Statement myStmt = null;
	ResultSet myRs = null;
	
	
	public static Connection connect() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/zeiterfassung", "root" , "");
	}
	
	public void addInvoice(int mitarbeiter_mitarbeiter_id, int projekt_projekt_id, String projektposition_bezeichnung, Date projektposition_datum, String projektposition_dauer) {
		PreparedStatement myStmt = null;
		Connection myConn = null;
		ResultSet myRs = null;
		String statement = "INSERT INTO projektposition ( mitarbeiter_mitarbeiter_id, projekt_projekt_id, projektposition_id, projektposition_bezeichnung, projektposition_dauer, projektposition_datum) VALUES (?,?,?,?,?,?)";
		
		try {
			// 1. Get a connection to database
			myConn = connect();
			
			// 2. Create a statement
			myStmt = myConn.prepareStatement(statement);
			myStmt.setString(1, mitarbeiter_id );
			myStmt.setString(2, projekt_id);
			myStmt.setString(3, taetigkeit);
			myStmt.setDate(3, timestamp);
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

	public void updateInvoice(int id, String mitarbeiter_id, String projekt_id, String taetigkeit, Date timestamp) {
		PreparedStatement myStmt = null;
		Connection myConn = null;
		ResultSet myRs = null;
		String statement = "UPDATE `projektposition` SET `mitarbeiter_mitarbeiter_id`=?,`projekt_projekt_id`=?,`projektposition_taetigkeit`=?,`projektposition_dauer`=?,`projektposition_timestamp`=? WHERE id=?";
		
		try {
			// 1. Get a connection to database
			myConn = connect();
			
			// 2. Create a statement
			myStmt = myConn.prepareStatement(statement);
			myStmt.setString(1, mitarbeiter_id);
			myStmt.setString(2, projekt_id);
			myStmt.setString(3, taetigkeit);
			myStmt.setDate(4, timestamp);
			myStmt.setInt(5, id);
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
	
	public List<Invoice> getAllInvoices(){
		ArrayList<Invoice> rechnungen = new ArrayList<>();
		try {
			// 1. Get a connection to database
			myConn = connect();
			
			// 2. Create a statement
			myStmt = myConn.createStatement();
			
			// 3. Execute SQL query
			myRs = myStmt.executeQuery("select * from projektposition");
			
			// 4. Process the result set
			while (myRs.next()) {
				Invoice invoice = new Invoice(myRs.getInt("id"),  myRs.getString("mitarbeiter_id"), myRs.getString("projekt_id"), myRs.getString("taetigkeit"), myRs.getDate("timestamp"));
				rechnungen.add(invoice);
			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		finally {
			if (myRs != null) {
				try {
					myRs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if (myStmt != null) {
				try {
					myStmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if (myConn != null) {
				try {
					myConn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return rechnungen;
	}

	@Override
	public void updateInvoice(int id, String mitarbeiter_id, String projekt_id, String taetigkeit_id, String taetigkeit,
			Date datum, String dauer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateInvoice(int projektposition_id, int mitarbeiter_mitarbeiter_id, int projekt_projekt_id,
			String projektposition_bezeichnung, Date projektposition_datum, String projektposition_dauer) {
		// TODO Auto-generated method stub
		
	}
}