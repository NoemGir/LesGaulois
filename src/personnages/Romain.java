package personnages;

public class Romain {
	private String nom;
	private int force;
	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}
	
	public String getNom() {
		return nom;
		
	}
	
	public int getForce() {
		return force;
	}
	
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + " »");
	}
	
	private String prendreParole() {
		return "Le romain " + nom + " :" ;
	}
	
	public void recevoirCoup(int forceCoup) {
		force -= forceCoup;
		if (force >0) {
			parler("Aïe");
		}else {
			parler("J'abandonne...");
		}
	}
	
	@Override
	public String toString() {
		return "Romain [nom=" + nom + ", force=" + force + "]";
		
	}
	
	public static void main(String[] args) {
		Romain ceasar = new Romain("Céasar",12);
		System.out.println(ceasar);
		System.out.println(ceasar.prendreParole());
		ceasar.parler("hoho");
		ceasar.recevoirCoup(2);
		System.out.println(ceasar);
	}
}
