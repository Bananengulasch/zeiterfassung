package zeiterfassung;

import java.sql.*;
import java.sql.Date;
import java.util.*;
public class InvoiceDAODBImpl implements InvoiceDAO {
	Connection myConn = null;
	Statement myStmt = null;
	ResultSet myRs = null;
	int mitarbeiter_id;
	int projekt_id;
	
	public static Connection connect() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/zeiterfassung", "root" , "");
	}
	
	public void addInvoice(int mitarbeiter_mitarbeiter_id, int projekt_projekt_id, String projektposition_bezeichnung, Date projektposition_datum, String projektposition_dauer) {
		PreparedStatement myStmt = null;
		Connection myConn = null;
		ResultSet myRs = null;
		String statement = "INSERT INTO projektposition ( mitarbeiter_mitarbeiter_id, projekt_projekt_id, projektposition_bezeichnung, projektposition_datum, projektposition_dauer) VALUES (?,?,?,?,?)";
		
		try {
			// 1. Get a connection to database
			myConn = connect();
			
			// 2. Create a statement
			myStmt = myConn.prepareStatement(statement);
			myStmt.setInt(1, mitarbeiter_mitarbeiter_id );
			myStmt.setInt(2, projekt_projekt_id);
			myStmt.setString(3, projektposition_bezeichnung);
			myStmt.setDate(4, projektposition_datum);
			myStmt.setString(5, projektposition_dauer);
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

	public void updateInvoice(int id, int mitarbeiter_id, int projekt_id, String taetigkeit, Date timestamp ,String projektposition_dauer) {
		PreparedStatement myStmt = null;
		Connection myConn = null;
		ResultSet myRs = null;
		String statement = "UPDATE `projektposition` SET `mitarbeiter_mitarbeiter_id`=?,`projekt_projekt_id`=?,`projektposition_bezeichnung`=?,`projektposition_datum`=?,`projektposition_dauer`=? WHERE projektposition_id=?";
		
		try {
			// 1. Get a connection to database
			myConn = connect();
			
			// 2. Create a statement
			myStmt = myConn.prepareStatement(statement);
			myStmt.setInt(1, mitarbeiter_id);
			myStmt.setInt(2, projekt_id);
			myStmt.setString(3, taetigkeit);
			myStmt.setDate(4, timestamp);
			myStmt.setString(5, projektposition_dauer);
			myStmt.setInt(6, id);
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
		ArrayList<Invoice> projekte_mitarbeiter = new ArrayList<>();
		try {
			// 1. Get a connection to database
			myConn = connect();
			
			// 2. Create a statement
			myStmt = myConn.createStatement();
			
			// 3. Execute SQL query
			myRs = myStmt.executeQuery("select * from projektposition");
			
			// 4. Process the result set
			while (myRs.next()) {
				Invoice invoice = new Invoice(myRs.getInt("projektposition_id"),  myRs.getInt("mitarbeiter_mitarbeiter_id"), myRs.getInt("projekt_projekt_id"), myRs.getString("projektposition_bezeichnung"), myRs.getDate("projektposition_datum"), myRs.getString("projektposition_dauer"));
				projekte_mitarbeiter.add(invoice);
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
		return projekte_mitarbeiter;
	}
	

	public void addMitarbeiter(String mitarbeiter_vn, String mitarbeiter_nn) {
		PreparedStatement myStmt = null;
		Connection myConn = null;
		ResultSet myRs = null;
		String statement = "INSERT INTO mitarbeiter (mitarbeiter_vn, mitarbeiter_nn ) VALUES (?,?)";
		
		try {
			// 1. Get a connection to database
			myConn = connect();
			
			// 2. Create a statement
			myStmt = myConn.prepareStatement(statement);
			myStmt.setString(1, mitarbeiter_vn);
			myStmt.setString(2, mitarbeiter_nn);
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
	

	public void updateMitarbeiter(int mitarbeiter_id, String mitarbeiter_vn, String mitarbeiter_nn) {
		PreparedStatement myStmt = null;
		Connection myConn = null;
		ResultSet myRs = null;
		String statement = "UPDATE `mitarbeiter` SET `mitarbeiter_vn`=?,`mitarbeiter_nn`=? WHERE mitarbeiter_id=?";
		
		try {
			// 1. Get a connection to database
			myConn = connect();
			
			// 2. Create a statement
			myStmt = myConn.prepareStatement(statement);
			myStmt.setString(1, mitarbeiter_vn);
			myStmt.setString(2, mitarbeiter_nn);
			myStmt.setInt(3, mitarbeiter_id);
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
	
	public List<Mitarbeiter> getAllMitarbeiter(){
		ArrayList<Mitarbeiter> mitarbeiterliste = new ArrayList<>();
		try {
			// 1. Get a connection to database
			myConn = connect();
			
			// 2. Create a statement
			myStmt = myConn.createStatement();
			
			// 3. Execute SQL query
			myRs = myStmt.executeQuery("select * from mitarbeiter");
			
			// 4. Process the result set
			while (myRs.next()) {
				Mitarbeiter mitarbeiter = new Mitarbeiter(myRs.getInt("mitarbeiter_id"),  myRs.getString("mitarbeiter_vn"), myRs.getString("mitarbeiter_nn"));
				mitarbeiterliste.add(mitarbeiter);
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
		return mitarbeiterliste;
	}
	
	public void addProjekt(String projekt_bezeichnung) {
		PreparedStatement myStmt = null;
		Connection myConn = null;
		ResultSet myRs = null;
		String statement = "INSERT INTO projekt (projekt_bezeichnung) VALUES (?)";
		
		try {
			// 1. Get a connection to database
			myConn = connect();
			
			// 2. Create a statement
			myStmt = myConn.prepareStatement(statement);
			myStmt.setString(1, projekt_bezeichnung);
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
	
	public List<Invoice> getSpecificMitarbeiterId(int mitarbeiter_mitarbeiter_id, int mitarbeiter_date){
		ArrayList<Invoice> mitarbeiter_specific = new ArrayList<>();
		PreparedStatement myStmt = null;
		Connection myConn = null;
		ResultSet myRs = null;
		String statement = "SELECT * FROM projektposition WHERE MONTH(projektposition.projektposition_datum) = ? AND mitarbeiter_mitarbeiter_id=?";		
		try {
			// 1. Get a connection to database
			myConn = connect();
			
			// 2. Create a statement
			myStmt = myConn.prepareStatement(statement);
			myStmt.setInt(1, mitarbeiter_date);
			myStmt.setInt(2, mitarbeiter_mitarbeiter_id);
			
			myRs = myStmt.executeQuery();
			
			while(myRs.next()) {
				Invoice invoice = new Invoice(myRs.getInt("projektposition_id"),  myRs.getInt("mitarbeiter_mitarbeiter_id"), myRs.getInt("projekt_projekt_id"), myRs.getString("projektposition_bezeichnung"), myRs.getDate("projektposition_datum"), myRs.getString("projektposition_dauer"));
				mitarbeiter_specific.add(invoice);
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
		return mitarbeiter_specific;
}
	
	public void updateProjekt(int projekt_id, String projekt_bezeichnung) {
		PreparedStatement myStmt = null;
		Connection myConn = null;
		ResultSet myRs = null;
		String statement = "UPDATE `projekt` SET `projekt_bezeichnung`=? WHERE projekt_id=?";
		
		try {
			// 1. Get a connection to database
			myConn = connect();
			
			// 2. Create a statement
			myStmt = myConn.prepareStatement(statement);
			myStmt.setString(1, projekt_bezeichnung);
			myStmt.setInt(2, projekt_id);
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
	
	public List<Projekt> getAllProjekte(){
		ArrayList<Projekt> projektliste = new ArrayList<>();
		try {
			// 1. Get a connection to database
			myConn = connect();
			
			// 2. Create a statement
			myStmt = myConn.createStatement();
			
			// 3. Execute SQL query
			myRs = myStmt.executeQuery("select * from projekt");
			
			// 4. Process the result set
			while (myRs.next()) {
				Projekt projekt = new Projekt(myRs.getInt("projekt_id"),  myRs.getString("projekt_bezeichnung"));
				projektliste.add(projekt);
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
		return projektliste;
	}
	
	public Integer getSpecificId(String mitarbeiter_nn){
		PreparedStatement myStmt = null;
		Connection myConn = null;
		ResultSet myRs = null;
		String statement = "SELECT mitarbeiter_id FROM mitarbeiter WHERE mitarbeiter_nn=?";
		
		try {
			// 1. Get a connection to database
			myConn = connect();
			
			// 2. Create a statement
			myStmt = myConn.prepareStatement(statement);
			myStmt.setString(1, mitarbeiter_nn);
			myRs = myStmt.executeQuery();
			
			while(myRs.next()) {
				 mitarbeiter_id = myRs.getInt("mitarbeiter_id");
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
		return mitarbeiter_id;
}
	
	public Integer getMitarbeiterHours(int mitarbeiter_id){
		PreparedStatement myStmt = null;
		Connection myConn = null;
		ResultSet myRs = null;
		String statement = "SELECT SUM(projektposition_dauer) AS 'Summe' FROM projektposition WHERE mitarbeiter_mitarbeiter_id = ?  AND MONTH(CURRENT_DATE()) = MONTH(projektposition_datum)";
		
		try {
			// 1. Get a connection to database
			myConn = connect();
			// 2. Create a statement
			myStmt = myConn.prepareStatement(statement);
			myStmt.setInt(1, mitarbeiter_id);
			myRs = myStmt.executeQuery();
			
			while(myRs.next()) {
				 mitarbeiter_id = myRs.getInt("Summe");
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
		return mitarbeiter_id;
}
	
	public Integer getSpecificProjektId(String projekt_bezeichnung){
		PreparedStatement myStmt = null;
		Connection myConn = null;
		ResultSet myRs = null;
		String statement = "SELECT projekt_id FROM projekt WHERE projekt_bezeichnung=?";
		
		try {
			// 1. Get a connection to database
			myConn = connect();
			
			// 2. Create a statement
			myStmt = myConn.prepareStatement(statement);
			myStmt.setString(1, projekt_bezeichnung);
			myRs = myStmt.executeQuery();
			
			while(myRs.next()) {
				projekt_id = myRs.getInt("projekt_id");
				
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
		return projekt_id;
}
}