import java.util.ArrayList;

public class EmploiTemps {
    private Departement departement;
    private String semestre;
    private String annee;
    private ArrayList<String> salles;
    private ArrayList<String> matieres;
    private ArrayList<String> crenaux;

    public EmploiTemps(Departement departement, String semestre, String annee,
                       ArrayList<String> salles, ArrayList<String> matieres, ArrayList<String> crenaux) {
        this.departement = departement;
        this.semestre = semestre;
        this.annee = annee;
        this.salles = (salles != null) ? salles : new ArrayList<>();
        this.matieres = (matieres != null) ? matieres : new ArrayList<>();
        this.crenaux = (crenaux != null) ? crenaux : new ArrayList<>();
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }

    public String getAnnee() {
        return annee;
    }

    public void setSalles(ArrayList<String> salles) {
        this.salles = salles;
    }

    public ArrayList<String> getSalles() {
        return salles;
    }

    public void setMatieres(ArrayList<String> matieres) {
        this.matieres = matieres;
    }

    public ArrayList<String> getMatieres() {
        return matieres;
    }

    public void setCrenaux(ArrayList<String> crenaux) {
        this.crenaux = crenaux;
    }

    public ArrayList<String> getCrenaux() {
        return crenaux;
    }
    public Departement getDepartement() {
        return departement;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder(
            "L'emploi du temps de " + annee + " " + semestre + " du " + departement.getNom() + "\n"
        );

        if (matieres != null && !matieres.isEmpty()) {
            String strMatieres = String.join(", ", matieres);
            str.append("\n\tLes étudiants étudient les matières :\n\t").append(strMatieres);
        }

        if (salles != null && !salles.isEmpty()) {
            String strSalles = String.join(", ", salles);
            str.append("\n\tDans les salles :\n\t").append(strSalles);
        }

        if (crenaux != null && !crenaux.isEmpty()) {
            String strCrenaux = String.join(", ", crenaux);
            str.append("\n\tSur les créneaux suivants :\n\t").append(strCrenaux);
        }

        return str.toString();
    }
}
