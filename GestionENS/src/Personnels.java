public class Personnels {
    public final static int LIMITE_SALARY = 2800;
    private double salary;
    private String nom;
    private int conges;

    public Personnels(String nom, double salary) {
        // On impose un salaire minimum
        if (salary < LIMITE_SALARY) {
            this.salary = LIMITE_SALARY;
        } else {
            this.salary = salary;
        }
        this.nom = nom;
        this.conges = 0;
    }

    public Personnels(String nom) {
        this.salary = LIMITE_SALARY;
        this.nom = nom;
        this.conges = 0;
    }

    public void setSalary(double salary) {
        if (salary < LIMITE_SALARY) {
            this.salary = LIMITE_SALARY;
        } else {
            this.salary = salary;
        }
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setConges(int conges) {
        this.conges = conges;
    }

    public String getNom() {
        return nom;
    }

    public double getSalary() {
        return salary;
    }

    public int getConges() {
        return conges;
    }
}
