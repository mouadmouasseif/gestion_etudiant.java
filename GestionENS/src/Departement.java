import java.util.ArrayList;

public class Departement {
	public String nom;
	public String chefDepartement;
	private ArrayList<Etudiant> etudiants;
	private ArrayList<Prof> prof;
	private ArrayList<String> annee;
		
	public Departement(String nom, String chefDepartement, ArrayList<String> annee, ArrayList<Prof> prof, ArrayList<Etudiant> etudiants) {
		this.nom = nom;
		this.chefDepartement = chefDepartement;
		this.annee = annee;
		this.prof = prof;
		this.etudiants = etudiants;
	}
	
	public Departement(String nom) {
		this.nom = nom;
		this.chefDepartement = "John Doe";
	}
	
	public Departement(String nom, String chefDepartement) {
		this.nom = nom;
		this.chefDepartement = chefDepartement;
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
	
	public ArrayList<String> getAnnee() {
		return annee;
	}
	
	public void setAnnee(ArrayList<String> annee) {
		this.annee = annee;
	}

	public ArrayList<Prof> getProf() {
		return prof;
	}
	
	public void setProf(ArrayList<Prof> prof) {
		this.prof = prof;
	}

	public ArrayList<Etudiant> getEtudiants() {
		return etudiants;
	}
	
	public void setEtudiants(ArrayList<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}
	
	public void addAnnee(String annee) {
		this.annee.add(annee);
		System.out.println(annee+" add into the liste");
	}
	
	public void deleteAnnee(String annee) {
		for(int i = 0; i < this.annee.size(); i++) {
			if ( this.annee.get(i).equals(annee) ) {
				this.annee.remove(i);
				System.out.println(annee+" was removed at "+i);
			}
		}
	}
	
	public String toString() {
		String str = "le departement de "+nom;
		
		String strChefDepartement = "";
		if ( chefDepartement != null ) {
			strChefDepartement = "\n\tqui est comme un chef de departement M."+chefDepartement;
		}

		String strAnnee = "";
		ArrayList<String> strListeAnnee = new ArrayList<String>();
		if ( annee != null ) {
			strListeAnnee.add(annee.get(0)+"");
			for ( int i = 1; i < annee.size(); i++ ) {
				strListeAnnee.add(annee.get(i)+"");
			}
			strAnnee = String.join(" ",strListeAnnee);
			strAnnee = "\n\tles etudiant est dans l'un des annee suivante: "+strAnnee;
		}

		String strProf = "";
		ArrayList<String> strListeProf = new ArrayList<String>();
		if ( prof != null ) {
			strListeProf.add(prof.get(0)+"");
			for ( int i = 1; i < prof.size(); i++ ) {
				strListeProf.add(prof.get(i)+"");
			}
			strProf = String.join(" ",strListeProf);
			strProf = "\n\tpour les professeurs on trouve: "+strProf;
		}

		String strEtudiants = "";
		ArrayList<String> strListeEtudiants = new ArrayList<String>();
		if ( etudiants != null ) {
			strListeEtudiants.add(etudiants.get(0)+"");
			for ( int i = 1; i < etudiants.size(); i++ ) {
				strListeEtudiants.add(etudiants.get(i)+"");
			}
			strEtudiants = String.join(" ",strListeEtudiants);
			strEtudiants = "\n\tpour les etudiants on trouve: "+strEtudiants;
		}
		
		return str.concat(strChefDepartement.concat(strProf.concat(strEtudiants.concat(strAnnee))));
	}
	
	public void collaborate(Departement autreDepartement) {
		System.out.println(this.nom+" now is collaborating with "+autreDepartement.getNom());
	}
	
}
