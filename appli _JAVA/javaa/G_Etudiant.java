package javaa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class G_Etudiant {
    private Connection connexion;

    public G_Etudiant() {
        try {
            connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/votre_base_de_donnees", "utilisateur", "mot_de_passe");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Etudiant> obtenirTousLesEtudiants() throws SQLException {
        List<Etudiant> listeEtudiants = new ArrayList<>();
        String requete = "SELECT * FROM Etudiants";
        try (PreparedStatement statement = connexion.prepareStatement(requete)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Etudiant etudiant = new Etudiant(resultSet.getString("ID"), resultSet.getString("Nom"));
                listeEtudiants.add(etudiant);
            }
        }
        return listeEtudiants;
    }

    public void ajouterEtudiant(String nom) throws SQLException {
        String requete = "INSERT INTO Etudiants (Nom) VALUES (?)";
        try (PreparedStatement statement = connexion.prepareStatement(requete)) {
            statement.setString(1, nom);
            statement.executeUpdate();
        }
    }

    public void modifierEtudiant(String id, String nouveauNom) throws SQLException {
        String requete = "UPDATE Etudiants SET Nom = ? WHERE ID = ?";
        try (PreparedStatement statement = connexion.prepareStatement(requete)) {
            statement.setString(1, nouveauNom);
            statement.setString(2, id);
            statement.executeUpdate();
        }
    }

    public void supprimerEtudiant(String id) throws SQLException {
        String requete = "DELETE FROM Etudiants WHERE ID = ?";
        try (PreparedStatement statement = connexion.prepareStatement(requete)) {
            statement.setString(1, id);
            statement.executeUpdate();
        }
    }
}
