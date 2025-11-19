import java.util.ArrayList;

public class Prof extends Personnels {
    private Departement departement;
    private ArrayList<String> matiere;

    public Prof(String nom, double salary, Departement departement, ArrayList<String> matiere) {
        super(nom, salary);
        this.departement = departement;
        this.matiere = matiere;
    }

    public Prof(String nom, Departement departement, ArrayList<String> matiere) {
        super(nom);
        this.departement = departement;
        this.matiere = matiere;
    }

    public Prof(String nom, ArrayList<String> matiere) {
        super(nom);
        this.matiere = matiere;
    }

    public void setMatiere(ArrayList<String> matiere) {
        this.matiere = matiere;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

    public Departement getDepartement() {
        return departement;
    }

    public ArrayList<String> getMatieres() {
        return matiere;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("Le professeur M. " + getNom());

        if (departement != null) {
            str.append(" appartient au département de ").append(departement.getNom());
        }

        str.append("\n\tIl a un salaire de ").append(getSalary()).append(" MAD");

        if (matiere != null && !matiere.isEmpty()) {
            String strMatiere = String.join(", ", matiere);
            str.append(", et il enseigne : ").append(strMatiere);
        }

        return str.toString();
    }

    public void teach(ArrayList<Etudiant> etudiants) {
        if (etudiants == null || etudiants.isEmpty()) {
            System.out.println(getNom() + " n'a aucun étudiant à enseigner.");
        } else {
            System.out.println(getNom() + " enseigne à la classe de " + etudiants.get(0).getNom() + " et ses camarades.");
        }
    }

    public void sendNotes(PersonnelsAdmin admin) {
        System.out.println(getNom() + " a envoyé les notes à " + admin.getNom() + ".");
    }
}
