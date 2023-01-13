public class Personnels {
	public final static int LIMITE_SALARY = 2800;
	private double salary;
	private String nom;
	private int conges;

	
	public Personnels(String nom, double salary) {
		this.salary = LIMITE_SALARY;
		this.nom = nom;
		this.conges = 0;
	}
	
	public Personnels(String nom) {
		this.salary = LIMITE_SALARY;
		this.nom = nom;
		this.conges = 0;
	}
	
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public void setconget(double salary) {
		this.salary = salary;
	}
	
	public String getNom() {
		return nom;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public double getConges() {
		return conges;
	}
}
