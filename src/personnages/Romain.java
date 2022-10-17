package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipement;
	private int nbEquipement = 0;
	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force; 
		this.equipement = new Equipement[2];
		assert (force>=0);
	}
	
	public String getNom() {
		return nom;
		
	}
	
	public int getForce() {
		return force;
	}
	
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "� " + texte + " �");
	}
	
	private String prendreParole() {
		return "Le romain " + nom + " :" ;
	}
	
	public void recevoirCoup(int forceCoup) {
		int forceInitiale = force;
		assert (forceCoup>=0);
		force -= forceCoup;
		if (force >0) {
			parler("A�e");
		}else {
			parler("J'abandonne...");
		}
		assert (force<forceInitiale);
	}
	
	public void presente(String text) {
		System.out.println("Le soldat " + nom + text + ".");
	}
	
	public void equipe(Equipement equip) {
		presente(" s'équipe avec un " + equip.getNom());
		nbEquipement ++;
		equipement[nbEquipement-1]=equip;
	}
	
	public void sEquiper(Equipement equip) {
		switch(nbEquipement) {
			case 2:
				presente(" est déja bien protégé !");
				break;
			case 1 :
				if (equip == equipement[0]) {
					presente(" possède deja un " + equip.getNom());
				} 
				else {
					equipe(equip);
				}
				break;
			case 0 :
				equipe(equip);
				break;
		}
	}
	
	@Override
	public String toString() {
		return "Romain [nom=" + nom + ", force=" + force + "]";
		
	}
	
	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
		minus.nom = "minus";
		minus.force = 6;
		System.out.println(minus);
		System.out.println(minus.prendreParole());
		minus.parler("hoho");
		minus.recevoirCoup(2);
		System.out.println(minus);
		System.out.println(Equipement.CASQUE);
		System.out.println(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
		
	}
}
