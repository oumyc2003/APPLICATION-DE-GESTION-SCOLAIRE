package javaa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class EtudiantController {
    private Connection connexion;
    private EtudiantModel modelEtudiant;

    public EtudiantController() {
        try {
            connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/votre_base_de_donnees", "utilisateur", "mot_de_passe");
            modelEtudiant = new EtudiantModel(connexion);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Etudiant> obtenirTousLesEtudiants() throws SQLException {
        return modelEtudiant.getAllEtudiants();
    }

    public void ajouterEtudiant(Etudiant etudiant) throws SQLException {
        modelEtudiant.ajouterEtudiant(etudiant);
    }

    public void modifierEtudiant(Etudiant etudiant) throws SQLException {
        modelEtudiant.modifierEtudiant(etudiant);
    }

    public void supprimerEtudiant(String id) throws SQLException {
        modelEtudiant.supprimerEtudiant(id);
    }
}
