import java.util.ArrayList;

public class Etudiant {
	private String nom;
	private int listNumber;
	private ArrayList<Double> notes;
	
	public Etudiant (String nom, int listNumber, ArrayList<Double> notes) {
		this.nom = nom;
		this.listNumber = listNumber;
		this.notes = notes;
	}
	
	public Etudiant (String nom, int listNumber) {
		this.nom = nom;
		this.listNumber = listNumber;
	}
	
	public Etudiant (String nom) {
		this.nom = nom;
	}
	
	public Etudiant (String nom, ArrayList<Double> notes) {
		this.nom = nom;
		this.notes = notes;
	}
		
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public int getListNumber() {
		return listNumber;
	}
	
	public void setListNumber(int listNumber) {
		this.listNumber = listNumber;
	}

	public ArrayList<Double> getNotes() {
		return notes;
	}

	public void setNotes(ArrayList<Double> notes) {
		this.notes = notes;
	}

	public String toString() {
		String str = "L'etudiant "+listNumber+" dans la liste c'est "+nom+" qui est les notes suivante: ";
		ArrayList<String> listeNotes = new ArrayList<String>();
		listeNotes.add(notes.get(0)+"");
		for ( int i = 1; i < notes.size(); i++ ) {
			listeNotes.add(notes.get(i)+"");
		}
		String strNotes = String.join(" ",listeNotes);
		return str.concat(strNotes);
	}

	
	public double calculerBulletin() {
		if ( notes != null ) {
			double result = 0;
			for(int i=0; i < notes.size(); i++ ) {
				if ( 20 >= notes.get(i)) { 
					result += notes.get(i);
				}
				else {
					System.out.println("une ou quelques notes sont faux");
					return -1;
				}
			}
			return result/notes.size();
		}
		else { 
			System.out.println("Remplir les notes d'abord");
			return -2;
		}
	}
}
