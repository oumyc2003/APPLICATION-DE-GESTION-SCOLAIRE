package javaa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Note {
    private Connection connection;

    public Note() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/votre_base_de_donnees", "utilisateur", "admin");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Méthode pour enregistrer une note dans la base de données
    public void enregistrerNote(String idEtudiant, String idCours, double valeur) throws SQLException {
        String query = "INSERT INTO Notes (idetudiant, idcours, valeur) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, idEtudiant);
            statement.setString(2, idCours);
            statement.setDouble(3, valeur);
            statement.executeUpdate();
        }
    }

    // Méthode pour récupérer toutes les notes d'un étudiant pour un cours donné
    public double recupererNoteEtudiantPourCours(String idEtudiant, String idCours) throws SQLException {
        String query = "SELECT valeur FROM Notes WHERE idetudiant = ? AND idcours = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, idEtudiant);
            statement.setString(2, idCours);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getDouble("valeur");
            }
        }
        return -1; // Retourne une valeur par défaut si aucune note n'est trouvée
    }

    // Méthode pour modifier une note dans la base de données
    public void modifierNote(String idEtudiant, String idCours, double nouvelleValeur) throws SQLException {
        String query = "UPDATE Notes SET valeur = ? WHERE idetudiant = ? AND idcours = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setDouble(1, nouvelleValeur);
            statement.setString(2, idEtudiant);
            statement.setString(3, idCours);
            statement.executeUpdate();
        }
    }

    // Méthode pour supprimer une note de la base de données
    public void supprimerNote(String idEtudiant, String idCours) throws SQLException {
        String query = "DELETE FROM Notes WHERE idetudiant = ? AND idcours = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, idEtudiant);
            statement.setString(2, idCours);
            statement.executeUpdate();
        }
    }
}
