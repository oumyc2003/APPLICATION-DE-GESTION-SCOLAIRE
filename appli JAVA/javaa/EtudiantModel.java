package javaa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EtudiantModel {
    private Connection connexion;

    public EtudiantModel(Connection connexion) {
        this.connexion = connexion;
    }

    public List<Etudiant> getAllEtudiants() throws SQLException {
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

    public void ajouterEtudiant(Etudiant etudiant) throws SQLException {
        String requete = "INSERT INTO Etudiants (Nom) VALUES (?)";
        try (PreparedStatement statement = connexion.prepareStatement(requete)) {
            statement.setString(1, etudiant.getNom());
            statement.executeUpdate();
        }
    }

    public void modifierEtudiant(Etudiant etudiant) throws SQLException {
        String requete = "UPDATE Etudiants SET Nom = ? WHERE ID = ?";
        try (PreparedStatement statement = connexion.prepareStatement(requete)) {
            statement.setString(1, etudiant.getNom());
            statement.setString(2, etudiant.getId());
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
