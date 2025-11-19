
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class FenetreEmploiTemps extends JFrame {

    public FenetreEmploiTemps(EmploiTemps et) {
        setTitle("Emploi du temps");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLayout(new BorderLayout());

        JLabel lblTitre = new JLabel("Emploi du temps", SwingConstants.CENTER);
        lblTitre.setFont(new Font("Arial", Font.BOLD, 16));

        JPanel infoPanel = new JPanel(new GridLayout(0, 1, 5, 5));
        infoPanel.add(new JLabel("Département : " + et.getDepartement().getNom()));
        infoPanel.add(new JLabel("Année : " + et.getAnnee()));
        infoPanel.add(new JLabel("Semestre : " + et.getSemestre()));

        // On va juste afficher les salles / matières / créneaux dans une textarea
        JTextArea area = new JTextArea();
        area.setEditable(false);

        ArrayList<String> salles = et.getSalles();
        ArrayList<String> matieres = et.getMatieres();
        ArrayList<String> crenaux = et.getCrenaux();

        area.append("Salles :\n");
        if (salles != null && !salles.isEmpty()) {
            for (String s : salles) area.append(" - " + s + "\n");
        } else {
            area.append("  Aucune salle définie.\n");
        }

        area.append("\nMatières :\n");
        if (matieres != null && !matieres.isEmpty()) {
            for (String m : matieres) area.append(" - " + m + "\n");
        } else {
            area.append("  Aucune matière définie.\n");
        }

        area.append("\nCréneaux :\n");
        if (crenaux != null && !crenaux.isEmpty()) {
            for (String c : crenaux) area.append(" - " + c + "\n");
        } else {
            area.append("  Aucun créneau défini.\n");
        }

        JScrollPane scroll = new JScrollPane(area);

        add(lblTitre, BorderLayout.NORTH);
        add(infoPanel, BorderLayout.WEST);
        add(scroll, BorderLayout.CENTER);
    }
}
