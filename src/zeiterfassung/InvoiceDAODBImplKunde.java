package zeiterfassung;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InvoiceDAODBImplKunde implements InvoiceDAOKunde {
	Connection myConn = null;
	Statement myStmt = null;
	ResultSet myRs = null;
	
	
	public static Connection connect() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/apr", "root" , "");
	}
	
	public List<InvoiceKunde> getAllInvoices(){
		ArrayList<InvoiceKunde> rechnungen = new ArrayList<>();
		try {
			// 1. Get a connection to database
			myConn = connect();
			
			// 2. Create a statement
			myStmt = myConn.createStatement();
			
			// 3. Execute SQL query
			myRs = myStmt.executeQuery("select * from kunde");
			
			// 4. Process the result set
			while (myRs.next()) {
				InvoiceKunde invoice = new InvoiceKunde(myRs.getInt("id"), myRs.getString("vname"), myRs.getString("nname"), myRs.getDate("birthdate"), myRs.getString("adress"), myRs.getString("email"), myRs.getString("number"),myRs.getInt("cars"),myRs.getString("besitz"));
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
	
	public void deleteInvoice(int id) {
		PreparedStatement myStmt = null;
		String statement = "DELETE from kunde WHERE id=?";
		
		try {
			// 1. Get a connection to database
			myConn = connect();
			
			myStmt = myConn.prepareStatement(statement);
			myStmt.setLong(1, id);
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
	}
	
	public void addInvoice(String vname, String nname, Date birthdate, String adress, String email, String number, int cars, String besitz) {
		PreparedStatement myStmt = null;
		Connection myConn = null;
		ResultSet myRs = null;
		String statement = "INSERT INTO kunde (vname, nname, birthdate, adress, email, number, cars, besitz) VALUES (?,?,?,?,?,?,?,?)";
		
		try {
			// 1. Get a connection to database
			myConn = connect();
			
			// 2. Create a statement
			myStmt = myConn.prepareStatement(statement);
			myStmt.setString(1, vname);
			myStmt.setString(2, nname);
			myStmt.setDate(3, birthdate);
			myStmt.setString(4, adress);
			myStmt.setString(5, email);
			myStmt.setString(6, number);
			myStmt.setInt(7, cars);
			myStmt.setString(8, besitz);
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

	public void updateInvoice(int id, String vname, String nname, Date birthdate, String adress, String email, String number, int cars, String besitz) {
		PreparedStatement myStmt = null;
		Connection myConn = null;
		ResultSet myRs = null;
		String statement = "UPDATE `kunde` SET `vname`=?,`nname`=?,`birthdate`=?,`adress`=?,`email`=?,`number`=?,`cars`=?,`besitz`=? WHERE id=?";
		
		try {
			// 1. Get a connection to database
			myConn = connect();
			
			// 2. Create a statement
			myStmt = myConn.prepareStatement(statement);
			myStmt.setString(1, vname);
			myStmt.setString(2, nname);
			myStmt.setDate(3, birthdate);
			myStmt.setString(4, adress);
			myStmt.setString(5, email);
			myStmt.setString(6, number);
			myStmt.setInt(7, cars);
			myStmt.setString(8, besitz);
			myStmt.setInt(9, id);
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
