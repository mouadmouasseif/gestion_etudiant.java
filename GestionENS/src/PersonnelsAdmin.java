import java.util.ArrayList;

public class PersonnelsAdmin extends Personnels {
    private String role;

    public PersonnelsAdmin(String nom, String role, double salary) {
        super(nom, salary);
        this.role = role;
    }

    public PersonnelsAdmin(String nom, String role) {
        super(nom);
        this.role = role;
    }

    public EmploiTemps creeEmploiTemps(Departement departement, String semestre, String annee,
                                       ArrayList<String> salles, ArrayList<String> matieres, ArrayList<String> crenaux) {
        return new EmploiTemps(departement, semestre, annee, salles, matieres, crenaux);
    }

    public void informerProf(Prof prof, String information) {
        System.out.println("Le prof " + prof.getNom() + " a été informé que \"" + information + "\" par " + getNom() + ".");
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void recevoirNotes(Prof prof) {
        System.out.println(getNom() + " a reçu les notes de " + prof.getNom() + ".");
    }

    @Override
    public String toString() {
        return "L'administrateur M. " + getNom() +
               ", son rôle est : " + role +
               ", il a un salaire de " + getSalary() + " MAD.";
    }
}
