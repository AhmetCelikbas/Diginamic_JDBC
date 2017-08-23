/**
 * 
 */
package fr.codevallee.formation.tp1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.codevallee.formation.tp1.models.Agence;

/**
 * @author keylan
 *
 */
 public class Database {
	 
	/* MySQL connection informations */
	private final String host = "localhost";
	private final String port = "3306";
	private final String database = "immobilier";
	private final String username = "root";
	private final String password = "root";
	
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rset;
	
	/**
	 * @throws SQLException
	 */
	public  void connect() throws SQLException {
		try {
			conn = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database + "?useSSL=false", username, password);
		} catch (SQLException e) {
			throw e;
		}
	}
	
	/**
	 * @param query
	 * @throws SQLException
	 */
	public List<Agence> select_agences_executeQuery() throws SQLException{
		try {
			stmt = conn.createStatement();
	        rset = stmt.executeQuery("select * from agence");

	        List<Agence> agences = new ArrayList<Agence>();
	        while(rset.next()) {   // Move the cursor to the next row, return false if no more row
	        		agences.add(new Agence(rset.getInt("idAgence"), rset.getString("nom"), rset.getString("adresse")));
	        }
	        
	        System.out.println("Total number of records returned = " + agences.size());
	        return agences;
		} catch (SQLException e) {
			throw e;
		}
	}
	
	
	/**
	 * @param query
	 * @throws SQLException
	 */
	public Agence select_agences_prepared(int idAgence) throws SQLException{
		try {
			pstmt = conn.prepareStatement("select * from agence where idAgence=?");
			pstmt.setInt(1, idAgence);
			pstmt.executeQuery();
	        rset = pstmt.executeQuery();

	        if(rset.next()) {   // Move the cursor to the next row, return false if no more row
	        		return new Agence(rset.getInt("idAgence"), rset.getString("nom"), rset.getString("adresse"));
	        } else {
	        		return null;
	        }
		} catch (SQLException e) {
			throw e;
		}
	}
}
