
import javax.swing.*;
import java.awt.*;

public class FenetrePersonnelsAdmin extends JFrame {

    public FenetrePersonnelsAdmin(PersonnelsAdmin admin) {
        setTitle("Fiche administrateur");
        setSize(450, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLayout(new BorderLayout());

        JLabel lblTitre = new JLabel("Informations de l'administrateur", SwingConstants.CENTER);
        lblTitre.setFont(new Font("Arial", Font.BOLD, 16));

        JPanel panel = new JPanel(new GridLayout(0, 1, 5, 5));

        JLabel lblNom = new JLabel("Nom : " + admin.getNom());
        JLabel lblRole = new JLabel("Rôle : " + admin.getRole());
        JLabel lblSalaire = new JLabel("Salaire : " + admin.getSalary() + " MAD");

        panel.add(lblNom);
        panel.add(lblRole);
        panel.add(lblSalaire);

        add(lblTitre, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
    }
}
