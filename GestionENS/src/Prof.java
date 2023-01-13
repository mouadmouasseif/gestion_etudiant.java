import java.util.ArrayList;

public class Prof extends Personnels {
	Departement departement;
	private ArrayList<String> matiere;

	public Prof(String nom, double salary, Departement departement ,ArrayList<String> matiere ) {
		super(nom, salary);
		this.departement = departement;
		this.matiere = matiere;
	}
	
	public Prof(String nom, Departement departement ,ArrayList<String> matiere ) {
		super(nom);
		this.matiere = matiere;
		this.departement = departement;
	}
	
	public Prof(String nom ,ArrayList<String> matiere ) {
		super(nom);
		this.matiere = matiere;
	}
	
	public void setMatiere( ArrayList<String> matiere ) {
		this.matiere = matiere;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}
	
	public Departement getDepartement() {
		return departement;
	}
	
	public ArrayList<String> getMatiere() {
		return matiere;
	}
	
	public String toString() {
		String str = "Le professeur M."+getNom();
		if (departement != null) {
			 str = "Le professeur M."+getNom()+" est appartiant au departement de "+departement.getNom();
		}
		str = str+"\n\tIl est un salaire de "+getSalary()+"MAD,";
		if ( matiere != null) {
			String strMatiere = String.join(", ", matiere);
			strMatiere = "et il enseigner "+strMatiere;
			str = str+strMatiere;
		}
		return str;
	}
	
	public void teach(ArrayList<Etudiant> etudiants) {
		System.out.println(this.getNom()+" is teaching "+etudiants.get(0)+" class");
	}
	
	public void sendNotes(PersonnelsAdmin admin) {
		System.out.println(this.getNom()+" sent note into "+admin.getNom());
	}
}