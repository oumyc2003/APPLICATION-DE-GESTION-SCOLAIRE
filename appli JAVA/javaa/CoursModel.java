package javaa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CoursModel {
    private Connection connection;

    public CoursModel(Connection connection) {
        this.connection = connection;
    }

    public List<Cours> getAllCours() throws SQLException {
        List<Cours> coursList = new ArrayList<>();
        String query = "SELECT * FROM Cours";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Cours cours = new Cours(resultSet.getString("ID"), resultSet.getString("Nom"));
                coursList.add(cours);
            }
        }
        return coursList;
    }

    public void ajouterCours(Cours cours) throws SQLException {
        String query = "INSERT INTO Cours (Nom, Description) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, cours.getCoursName());
            statement.setString(2, cours.getDescription());
            statement.executeUpdate();
        }
    }

    public void modifierCours(Cours cours) throws SQLException {
        String query = "UPDATE Cours SET Nom = ?, Description = ? WHERE ID = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, cours.getCoursName());
            statement.setString(2, cours.getDescription());
            statement.setString(3, cours.getCoursId());
            statement.executeUpdate();
        }
    }

    public void supprimerCours(String id) throws SQLException {
        String query = "DELETE FROM Cours WHERE ID = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, id);
            statement.executeUpdate();
        }
    }
}

