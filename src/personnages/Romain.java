package personnages;

public class Romain {
	private String nom;
	private int force;
	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force; 
		assert (force>=0);
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
		int forceInitiale = force;
		assert (forceCoup>=0);
		force -= forceCoup;
		if (force >0) {
			parler("Aïe");
		}else {
			parler("J'abandonne...");
		}
		assert (force<forceInitiale);
	}
	
	@Override
	public String toString() {
		return "Romain [nom=" + nom + ", force=" + force + "]";
		
	}
	
	public static void main(String[] args) {
		Romain minus = new Romain("Minus",6);
		System.out.println(minus);
		System.out.println(minus.prendreParole());
		minus.parler("hoho");
		minus.recevoirCoup(2);
		System.out.println(minus);
	}
}
