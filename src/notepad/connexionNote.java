package notepad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import utilisateur.note;

public class connexionNote {
	private String url ="jdbc:mysql://localhost/java_note ?useUnicode=true &useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false& serverTimezone=UTC"  ;
	private String utilisateur = "root";
    private String motDePasse = "";
    static final String InsertionSQL="INSERT INTO notepad "+ " (titre, contenu)"
    		+ " VALUES "+ " (?, ?);";

    protected Connection getConnection () {
  		Connection connection =null; 
  		try {
  			Class.forName("com.mysql.cj.jdbc.Driver"); 
  			//FORNAME methode on renseigne le lieu de la base de donnée 
  			
  			connection = DriverManager.getConnection(url, utilisateur , motDePasse);
  		}catch (Exception e) {
  			e.printStackTrace();
  			System.out.println("La connexion a échouée");
  			
  		}
  		return connection; 
  	}
      
      public boolean ajouter(note note) { 
  		try(
  				Connection connection =getConnection();
  				PreparedStatement ps=connection.prepareStatement(InsertionSQL))
  		{
  			ps.setString(1, note.getTitre());
  			ps.setString(2, note.getContenu());
  			
  			return ps.executeUpdate()>0;	
  			
  		}
  		catch(Exception e) {
  			e.printStackTrace();
  			return false;
  		}
  	} 
}
