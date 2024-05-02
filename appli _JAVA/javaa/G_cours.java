package javaa;

import java.sql.Connection;
        import java.sql.DriverManager;
        import java.sql.PreparedStatement;
        import java.sql.ResultSet;
        import java.sql.SQLException;
        import java.util.ArrayList;
        import java.util.List;
        
        public class G_cours {
            private Connection connection;
        
            public G_cours() {
                try {
                    connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/votre_base_de_donnees", "utilisateur", "mot_de_passe");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
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
        
            public void ajouterCours(String nom, String description) throws SQLException {
                String query = "INSERT INTO Cours (Nom, Description) VALUES (?, ?)";
                try (PreparedStatement statement = connection.prepareStatement(query)) {
                    statement.setString(1, nom);
                    statement.setString(2, description);
                    statement.executeUpdate();
                }
            }
        
            public void modifierCours(String id, String nom, String description) throws SQLException {
                String query = "UPDATE Cours SET Nom = ?, Description = ? WHERE ID = ?";
                try (PreparedStatement statement = connection.prepareStatement(query)) {
                    statement.setString(1, nom);
                    statement.setString(2, description);
                    statement.setString(3, id);
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
