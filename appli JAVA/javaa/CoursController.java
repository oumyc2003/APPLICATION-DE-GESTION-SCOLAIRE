package javaa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class CoursController {
    private Connection connection;
    private CoursModel coursModel;

    public CoursController() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/votre_base_de_donnees", "utilisateur", "admin");
            coursModel = new CoursModel(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Cours> getAllCours() throws SQLException {
        return coursModel.getAllCours();
    }

    public void ajouterCours(Cours cours) throws SQLException {
        coursModel.ajouterCours(cours);
    }

    public void modifierCours(Cours cours) throws SQLException {
        coursModel.modifierCours(cours);
    }

    public void supprimerCours(String id) throws SQLException {
        coursModel.supprimerCours(id);
    }
}

