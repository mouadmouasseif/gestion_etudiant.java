import java.util.ArrayList;

public class EmploiTemps {
	Departement departement;
	private String semestre;
	private String annee;
	private ArrayList<String> salles;
	private ArrayList<String> matieres;
	private ArrayList<String> crenaux;
	
	public EmploiTemps(Departement departement, String semestre, String annee, ArrayList<String> salles, ArrayList<String> matieres, ArrayList<String> crenaux) {
		this.semestre = semestre;
		this.annee = annee;
		this.salles = salles;
		this.matieres = matieres;
		this.crenaux = crenaux;
		this.departement = departement;
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
	
	public String toString() {
		String str = "L'emploi de temps de "+annee+" "+semestre+" de "+departement.toString()+"\n";
		
		
		ArrayList<String> strListeSalles = new ArrayList<String>();
		String strSalles = "";
		if (salles.size() > 0) {
			strListeSalles.add(salles.get(0));
			for ( int i = 1; i < salles.size(); i++ ) {
				strListeSalles.add(salles.get(i));
			}
			strSalles = String.join(" ",strListeSalles);
			strSalles = "\n\t dans les salles: \n\t"+strSalles;
		}
		
		ArrayList<String> strListeMatieres = new ArrayList<String>();
		String strMatieres = "";
		if (matieres.size() > 0) {
			strListeMatieres.add(matieres.get(0));
			for ( int i = 1; i < matieres.size(); i++ ) {
				strListeMatieres.add(matieres.get(i));
			}
			strMatieres = String.join(" ",strListeMatieres);
			strMatieres = "\n\tils etude les matieres: \n\t"+strMatieres;
		}
		
		ArrayList<String> strListeCrenaux = new ArrayList<String>();
		String strCrenaux = "";
		if (crenaux.size() > 0) {
			strListeCrenaux.add(crenaux.get(0));
			for ( int i = 1; i < crenaux.size(); i++ ) {
				strListeCrenaux.add(crenaux.get(i));
			}
			strCrenaux = String.join(" ",strListeCrenaux);
			strCrenaux = "\n\tdans les crenaux suivante: \n\t"+strCrenaux;
		}
		str = str+strMatieres+strSalles+strCrenaux;
		
		return str;
	}
	//Salle/Cronaux : Dispo/Indispo...		
}
