import javax.swing.*;
import java.awt.*;

public class FenetreDepartement extends JFrame {

    public FenetreDepartement(Departement departement) {
        setTitle("Fiche département");
        setSize(450, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLayout(new BorderLayout());

        JLabel lblTitre = new JLabel("Informations du département", SwingConstants.CENTER);
        lblTitre.setFont(new Font("Arial", Font.BOLD, 16));

        JPanel panel = new JPanel(new GridLayout(0, 1, 5, 5));

        JLabel lblNom = new JLabel("Nom : " + departement.getNom());
        JLabel lblChef = new JLabel("Chef de département : " + departement.getChefDepartement());
        int nbProfs = (departement.getProfs() != null) ? departement.getProfs().size() : 0;
        int nbEtudiants = (departement.getEtudiants() != null) ? departement.getEtudiants().size() : 0;

        JLabel lblNbProfs = new JLabel("Nombre de professeurs : " + nbProfs);
        JLabel lblNbEtudiants = new JLabel("Nombre d'étudiants : " + nbEtudiants);

        panel.add(lblNom);
        panel.add(lblChef);
        panel.add(lblNbProfs);
        panel.add(lblNbEtudiants);

        add(lblTitre, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
    }
}
