
import javax.swing.*;
import java.util.ArrayList;


public class Main {



    public static void main(String[] args) {

        ArrayList<Double> notes = new ArrayList<>();
        notes.add(12.0);
        notes.add(14.5);
        notes.add(9.75);

        Etudiant etu = new Etudiant("Salah Eddine", 18, notes);

        ArrayList<String> matieres = new ArrayList<>();
        matieres.add("POO");
        matieres.add("BD");

        Departement depInfo = new Departement("Informatique", "Ahmed Ahmadi");
        Prof prof = new Prof("Ahmed Ahmadi", depInfo, matieres);

        depInfo.addEtudiant(etu);
        depInfo.addProf(prof);

        PersonnelsAdmin admin = new PersonnelsAdmin("Ilyass Erradi", "Scolarité");

        ArrayList<String> salles = new ArrayList<>();
        salles.add("Salle 1");
        salles.add("Salle 2");

        ArrayList<String> crenaux = new ArrayList<>();
        crenaux.add("Lundi 8h-10h");
        crenaux.add("Mardi 10h-12h");

        EmploiTemps et = new EmploiTemps(depInfo, "S5", "2024-2025", salles, matieres, crenaux);

        SwingUtilities.invokeLater(() -> {

        	JFrame menu = new JFrame("Menu test des fenêtres");
            menu.setSize(400, 300);
            menu.setLocationRelativeTo(null);
            menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            menu.setLayout(new java.awt.GridLayout(0, 1, 5, 5));

            JButton btnEtudiant = new JButton("Voir Etudiant");
            JButton btnProf = new JButton("Voir Prof");
            JButton btnDep = new JButton("Voir Département");
            JButton btnPers = new JButton("Voir Personnel (Prof)");
            JButton btnAdmin = new JButton("Voir Admin");
            JButton btnET = new JButton("Voir Emploi du temps");

            btnEtudiant.addActionListener(e -> new FenetreEtudiant(etu).setVisible(true));
            btnProf.addActionListener(e -> new FenetreProf(prof).setVisible(true));
            btnDep.addActionListener(e -> new FenetreDepartement(depInfo).setVisible(true));
            btnPers.addActionListener(e -> new FenetrePersonnels(prof).setVisible(true));
            btnAdmin.addActionListener(e -> new FenetrePersonnelsAdmin(admin).setVisible(true));
            btnET.addActionListener(e -> new FenetreEmploiTemps(et).setVisible(true));

            menu.add(btnEtudiant);
            menu.add(btnProf);
            menu.add(btnDep);
            menu.add(btnPers);
            menu.add(btnAdmin);
            menu.add(btnET);

            menu.setVisible(true);
        });
    }
}
