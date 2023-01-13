import java.util.ArrayList;

public class PersonnelsAdmin extends Personnels {
	String role;
	
	public PersonnelsAdmin(String nom, String role, double salary) {
		super(nom,salary);
		this.role = role;
	}
	
	public PersonnelsAdmin(String nom, String role) {
		super(nom);
		this.role = role;
	}
	
	public EmploiTemps CreeEmploiTemps(Departement departement, String semestre, String annee, ArrayList<String> salles, ArrayList<String> matieres, ArrayList<String> crenaux) {
		EmploiTemps et = new EmploiTemps(departement, semestre, annee, salles, matieres, crenaux);
		return et;
	}
	
	public void informerProf(Prof prof, String information) {
		System.out.println("le prof "+prof.getNom()+" etait informer que "+information+" par "+getNom());
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	public void recieveNotes(Prof prof) {
		System.out.println(this.getNom()+" recieved notes from "+prof.getNom());
	}
	
	public String toString() {
		String str = "L'admenistrateur M."+getNom()+" son role est de "+role+", il est un salaire de "+getSalary();
		return str;
	}
}