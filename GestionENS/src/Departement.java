import java.util.ArrayList;

public class Departement {
    private String nom;
    private String chefDepartement;
    private ArrayList<Etudiant> etudiants;
    private ArrayList<Prof> profs;
    private ArrayList<String> annees;

    public Departement(String nom, String chefDepartement, ArrayList<String> annees, ArrayList<Prof> profs, ArrayList<Etudiant> etudiants) {
        this.nom = nom;
        this.chefDepartement = chefDepartement;
        this.annees = (annees != null) ? annees : new ArrayList<>();
        this.profs = (profs != null) ? profs : new ArrayList<>();
        this.etudiants = (etudiants != null) ? etudiants : new ArrayList<>();
    }

    public Departement(String nom) {
        this.nom = nom;
        this.chefDepartement = "John Doe";
        this.annees = new ArrayList<>();
        this.profs = new ArrayList<>();
        this.etudiants = new ArrayList<>();
    }

    public Departement(String nom, String chefDepartement) {
        this.nom = nom;
        this.chefDepartement = chefDepartement;
        this.annees = new ArrayList<>();
        this.profs = new ArrayList<>();
        this.etudiants = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getChefDepartement() {
        return chefDepartement;
    }

    public void setChefDepartement(String chefDepartement) {
        this.chefDepartement = chefDepartement;
    }

    public ArrayList<String> getAnnees() {
        return annees;
    }

    public void setAnnees(ArrayList<String> annees) {
        this.annees = annees;
    }

    public ArrayList<Prof> getProfs() {
        return profs;
    }

    public void setProfs(ArrayList<Prof> profs) {
        this.profs = profs;
    }

    public ArrayList<Etudiant> getEtudiants() {
        return etudiants;
    }

    public void setEtudiants(ArrayList<Etudiant> etudiants) {
        this.etudiants = etudiants;
    }

    public void addAnnee(String annee) {
        if (this.annees == null) {
            this.annees = new ArrayList<>();
        }
        this.annees.add(annee);
        System.out.println(annee + " a été ajoutée à la liste des années.");
    }
    public void addEtudiant(Etudiant e) {

    }
    public void addProf(Prof p) { 
    	
    	
    }


    public void deleteAnnee(String annee) {
        if (this.annees == null || this.annees.isEmpty()) {
            System.out.println("Aucune année à supprimer.");
            return;
        }
        boolean removed = this.annees.remove(annee);
        if (removed) {
            System.out.println(annee + " a été supprimée de la liste.");
        } else {
            System.out.println(annee + " n'existe pas dans la liste.");
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("Le département de " + nom);

        if (chefDepartement != null) {
            str.append("\n\tle chef de département est M. ").append(chefDepartement);
        }

        if (annees != null && !annees.isEmpty()) {
            String listeAnnees = String.join(", ", annees);
            str.append("\n\tles étudiants sont dans l'une des années suivantes : ").append(listeAnnees);
        }

        if (profs != null && !profs.isEmpty()) {
            ArrayList<String> strListeProf = new ArrayList<>();
            for (Prof p : profs) {
                strListeProf.add(p.getNom());
            }
            String listeProfs = String.join(", ", strListeProf);
            str.append("\n\tles professeurs du département sont : ").append(listeProfs);
        }

        if (etudiants != null && !etudiants.isEmpty()) {
            ArrayList<String> strListeEtudiants = new ArrayList<>();
            for (Etudiant e : etudiants) {
                strListeEtudiants.add(e.getNom());
            }
            String listeEtu = String.join(", ", strListeEtudiants);
            str.append("\n\tles étudiants du département sont : ").append(listeEtu);
        }

        return str.toString();
    }

    public void collaborate(Departement autreDepartement) {
        System.out.println(this.nom + " est maintenant en collaboration avec " + autreDepartement.getNom());
    }
}
