
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class FenetreProf extends JFrame {

    public FenetreProf(Prof prof) {
        setTitle("Fiche professeur");
        setSize(450, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLayout(new BorderLayout());

        JLabel lblTitre = new JLabel("Informations du professeur", SwingConstants.CENTER);
        lblTitre.setFont(new Font("Arial", Font.BOLD, 16));

        JPanel panel = new JPanel(new GridLayout(0, 1, 5, 5));

        JLabel lblNom = new JLabel("Nom : " + prof.getNom());
        JLabel lblSalaire = new JLabel("Salaire : " + prof.getSalary() + " MAD");

        String dep = (prof.getDepartement() != null)
                ? prof.getDepartement().getNom()
                : "Aucun département";
        JLabel lblDep = new JLabel("Département : " + dep);

        ArrayList<String> matieres = prof.getMatieres();
        String matieresTxt = "Aucune matière";
        if (matieres != null && !matieres.isEmpty()) {
            matieresTxt = String.join(", ", matieres);
        }
        JLabel lblMatieres = new JLabel("Matières : " + matieresTxt);

        panel.add(lblNom);
        panel.add(lblSalaire);
        panel.add(lblDep);
        panel.add(lblMatieres);

        add(lblTitre, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
    }
}
