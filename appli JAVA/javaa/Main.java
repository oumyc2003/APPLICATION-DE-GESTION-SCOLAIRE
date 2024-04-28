package javaa;

public import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Connexion à la base de données
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/votre_base_de_donnees", "utilisateur", "mot_de_passe")) {
            // Instanciation des contrôleurs
            CoursController controleurCours = new CoursController(connection);
            EtudiantController controleurEtudiant = new EtudiantController (connection);
               // Ajout d'un cours
        }
           
    }
           
}        
        //?????? probleme de try catch//
