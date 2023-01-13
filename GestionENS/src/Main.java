import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		ArrayList<String> annee = new ArrayList<String>();
		annee.add("3eme annee");
		annee.add("2eme annee");
		annee.add("TMW");
		
		ArrayList<String> matiere = new ArrayList<String>();
		matiere.add("POO");
		matiere.add("OS");
		matiere.add("BD");
		
		ArrayList<Double> notes = new ArrayList<Double>();
		double note = 8;
		while ( note < 14 ) {
			notes.add(note);
			note *= 1.2;
		}

		System.out.println("\nEtudiant toString\n");
		Etudiant etudiant = new Etudiant("Salah Eddine",18,notes);
		System.out.println(etudiant.toString());
		System.out.println("\nEtudiant calculer bulletin\n");
		System.out.println(etudiant.calculerBulletin());

		System.out.println("\ndepartement B toString\n");
		Departement departementb = new Departement("Francais", "Karim Aksbi");
		System.out.println(departementb.toString());


		ArrayList<Prof> profs = new ArrayList<Prof>();
		Prof profa = new Prof("Ahmed Ahmadi",matiere);
		Prof profb = new Prof("Anass Erradi",matiere);
		profs.add(profa);
		profs.add(profb);
		

		ArrayList<Etudiant> etudiants = new ArrayList<Etudiant>();
		Etudiant etudiantb = new Etudiant("Haitam",37,notes);
		etudiants.add(etudiant);
		etudiants.add(etudiantb);
		

		System.out.println("\ndepartement toString\n");
		Departement departement = new Departement("Informatique", "Ahmed Ahmadi", annee, profs, etudiants);
		System.out.println(departement.toString());
		

		System.out.println("\ndepartement A toString\n");
		Departement departementa = new Departement("Mathematique");
		System.out.println(departementa.toString());
		System.out.println("\ndepartement collaboration\n");
		departementa.collaborate(departement);
		

		System.out.println("\nProf toString\n");
		Prof prof = new Prof("Ahmed Ahmadi", departement, matiere);
		System.out.println(prof.toString());

		ArrayList<String> salles = new ArrayList<String>();
		matiere.add("Salle 1");
		matiere.add("Salle 2");
		matiere.add("Salle 3");
		ArrayList<String> crenaux = new ArrayList<String>();
		matiere.add("crenaux 1");
		matiere.add("crenaux 2");
		matiere.add("crenaux 3");
		System.out.println("\nPersonnels Admin toString\n");
		PersonnelsAdmin admin = new PersonnelsAdmin("Ilyass Erradi","scolarite");
		System.out.println(admin.toString());
		System.out.println("\nPersonnels Admin informer\n");
		admin.informerProf(prof, "Les exams est proche!");
		System.out.println("\nPersonnels Admin recevoire les notes\n");
		admin.recieveNotes(prof);
		
		System.out.println("\nEmploi de temps toString\n");
		EmploiTemps et = admin.CreeEmploiTemps(departement, "S5", "CLE INFO", salles, matiere, crenaux);
		System.out.println(et.toString());
	}
}
