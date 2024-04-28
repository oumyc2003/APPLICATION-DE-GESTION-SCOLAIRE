package javaa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Inscription {
    private String idEtudiant;
    private String idCours;

    public Inscription(String idEtudiant, String idCours) {
        this.idEtudiant = idEtudiant;
        this.idCours = idCours;
    }

    public String getIdEtudiant() {
        return idEtudiant;
    }

    public void setIdEtudiant(String idEtudiant) {
        this.idEtudiant = idEtudiant;
    }

    public String getIdCours() {
        return idCours;
    }

    public void setIdCours(String idCours) {
        this.idCours = idCours;
    }

    // Méthode pour enregistrer une inscription dans la base de données
    public void enregistrerInscription(Connection connection) throws SQLException {
        String query = "INSERT INTO Inscriptions (id_etudiant, id_cours) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, idEtudiant);
            statement.setString(2, idCours);
            statement.executeUpdate();
        }
    }
}
