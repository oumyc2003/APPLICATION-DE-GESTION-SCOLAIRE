package javaa;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Inscription {
    private Connection connection;

    public Inscription(Connection connection) {
        this.connection = connection;
    }

    // Méthode pour authentifier l'étudiant
    public boolean authentifierEtudiant(String nom, String motDePasse) throws SQLException {
        String query = "SELECT * FROM etudiants WHERE nom = ? AND mot_de_passe = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, nom);
            statement.setString(2, motDePasse);
            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next(); // Si une ligne est retournée, l'étudiant est authentifié
            }
        }
    }

    // Méthode pour inscrire un étudiant à un cours
    public void inscrireEtudiant(int idEtudiant, int idCours) throws SQLException {
        // Vérifier si l'étudiant et le cours existent
        if (!estEtudiantExiste(idEtudiant) || !estCoursExiste(idCours)) {
            System.out.println("L'étudiant ou le cours n'existe pas.");
            return;
        }

        // Enregistrer l'inscription dans la base de données
        String query = "INSERT INTO inscriptions (id_etudiant, id_cours) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idEtudiant);
            statement.setInt(2, idCours);
            statement.executeUpdate();
            System.out.println("Inscription réussie pour l'étudiant avec l'ID " + idEtudiant + " au cours avec l'ID " + idCours);
        }
    }

    // Méthode pour vérifier si un étudiant existe
    private boolean estEtudiantExiste(int idEtudiant) throws SQLException {
        String query = "SELECT * FROM etudiants WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idEtudiant);
            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next(); // Si une ligne est retournée, l'étudiant existe
            }
        }
    }

    // Méthode pour vérifier si un cours existe
    private boolean estCoursExiste(int idCours) throws SQLException {
        String query = "SELECT * FROM cours WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idCours);
            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next(); // Si une ligne est retournée, le cours existe
            }
        }
    }

}
 

