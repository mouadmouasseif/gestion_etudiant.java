
import javax.swing.*;
import java.awt.*;

public class FenetreEtudiant extends JFrame {

    public FenetreEtudiant(Etudiant etudiant) {
        setTitle("Fiche étudiant");
        setSize(400, 300);
        setLocationRelativeTo(null); // centre la fenêtre
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLayout(new BorderLayout());

        // Panel principal
        JPanel panel = new JPanel(new GridLayout(0, 1, 5, 5));

        JLabel lblTitre = new JLabel("Informations de l'étudiant", SwingConstants.CENTER);
        lblTitre.setFont(new Font("Arial", Font.BOLD, 16));

        JLabel lblNom = new JLabel("Nom : " + etudiant.getNom());
        JLabel lblNum = new JLabel("Numéro de liste : " + etudiant.getListNumber());

        double moyenne = etudiant.calculerBulletin();
        String txtMoyenne;
        if (moyenne == -2) {
            txtMoyenne = "Moyenne : notes non définies";
        } else if (moyenne == -1) {
            txtMoyenne = "Moyenne : notes incorrectes";
        } else {
            txtMoyenne = String.format("Moyenne : %.2f / 20", moyenne);
        }
        JLabel lblMoyenne = new JLabel(txtMoyenne);

        panel.add(lblNom);
        panel.add(lblNum);
        panel.add(lblMoyenne);

        add(lblTitre, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
    }
}
