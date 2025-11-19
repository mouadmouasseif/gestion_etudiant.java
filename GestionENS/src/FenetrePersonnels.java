import javax.swing.*;
import java.awt.*;

public class FenetrePersonnels extends JFrame {

    public FenetrePersonnels(Personnels pers) {
        setTitle("Fiche personnel");
        setSize(400, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLayout(new BorderLayout());

        JLabel lblTitre = new JLabel("Informations du personnel", SwingConstants.CENTER);
        lblTitre.setFont(new Font("Arial", Font.BOLD, 16));

        JPanel panel = new JPanel(new GridLayout(0, 1, 5, 5));

        JLabel lblNom = new JLabel("Nom : " + pers.getNom());
        JLabel lblSalaire = new JLabel("Salaire : " + pers.getSalary() + " MAD");
        JLabel lblConges = new JLabel("Congés : " + pers.getConges() + " jour(s)");

        panel.add(lblNom);
        panel.add(lblSalaire);
        panel.add(lblConges);

        add(lblTitre, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
    }
}
