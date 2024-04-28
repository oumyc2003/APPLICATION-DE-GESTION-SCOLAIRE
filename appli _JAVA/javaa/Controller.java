package javaa;

import java.sql.SQLException;
import java.util.List;

public class Controller {
    private CoursController coursController;
    private EtudiantController etudiantController;
   

    public Controller(CoursController coursController, EtudiantController etudiantController) {
        this.coursController = coursController;
        this.etudiantController = etudiantController;
        
    }
// partie pour permettre al'utilisateur pour les cour
 
    public List<Cours> getAllCours() throws SQLException {
        return coursController.getAllCours();
    }

    public void ajouterCours(Cours cours) throws SQLException {
        coursController.ajouterCours(cours);
    }

    public void modifierCours(Cours cours) throws SQLException {
        coursController.modifierCours(cours);
    }

    public void supprimerCours(String id) throws SQLException {
        coursController.supprimerCours(id);
    }

//partie pour permettre al'utilisateur gere les etudiants

    public void ajouterEtudiant(Etudiant etudiant) throws SQLException {
        etudiantController.ajouterEtudiant(etudiant);
    }

    public void modifierEtudiant(Etudiant etudiant) throws SQLException {
        etudiantController.modifierEtudiant(etudiant);
    }

    public void supprimerEtudiant(String id) throws SQLException {
        etudiantController.supprimerEtudiant(id);
    }

    

}
