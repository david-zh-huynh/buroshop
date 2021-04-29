package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

public class BestellungenDBUtil {
	
private DataSource dataSource;
	
	// Konstruktor um das DataSource vom Servlet zu übergeben
	public BestellungenDBUtil (DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public List<Bestellung> getbestellungen() throws Exception {
		
		// Leere Liste für die Bestellungen erstellen
		List<Bestellung> bestellungen = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStat = null;
		ResultSet myRes = null;
		
			try {
			// Eine Verbindung zur Datenbanmk erstellen
			myConn = dataSource.getConnection();
			
			// Das SQL statement zusammenstellen
			String sql = "select * from bestellungen ORDER BY bestellungsId";
			myStat = myConn.createStatement();
			
			// Das SQL Statement ausführen 
			myRes = myStat.executeQuery(sql);
			
			while (myRes.next()) {
				
				int bestellungsId = myRes.getInt("bestellungsId");
				String vorname = myRes.getString("vorname");
				String nachname = myRes.getString("nachname");
				String artikel = myRes.getString("artikel");
				int anzahl = myRes.getInt("anzahl");
				float preis = myRes.getFloat("preis");
				
				// Eine ein Bestellungs-Objekt erstellen um die Daten aus der Datenbank zu übertragen.
				Bestellung tempBestellung = new Bestellung(bestellungsId, vorname, nachname, artikel, anzahl, preis);
				
				// Die Bestellung der Liste hinzufügen.
				bestellungen.add(tempBestellung);
				
			}
			return bestellungen;
			
		} finally {
			// Die JDBC Objekte wieder schliessen
			close(myConn, myStat, myRes);
		}
	}
	
	
	private void close(Connection myConn, Statement myStat, ResultSet myRes) {
		try {
			if (myRes != null) {
				myRes.close();
			}
			
			if (myStat != null) {
				myStat.close();
			}
			
			if (myConn != null) {
				myConn.close();
			}
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
}
