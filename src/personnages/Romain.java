package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements;
	private int nbEquipement = 0;
	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force; 
		this.equipements = new Equipement[2];
		assert (force>=0);
	}
	
	public String getNom() {
		return nom;
		
	}
	
	public int getForce() {
		return force;
	}
	
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "<< " + texte + " >>");
	}
	
	private String prendreParole() {
		return "Le romain " + nom + " :" ;
	}
	
//	public void recevoirCoup(int forceCoup) {
//		int forceInitiale = force;
//		assert (forceCoup>=0);
//		force -= forceCoup;
//		if (force >0) {
//			parler("Aie");
//		}else {
//			parler("J'abandonne...");
//		}
//		assert (force<forceInitiale);
//	}
	
	
	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// precondition
		assert force > 0;
		int oldForce = force;
		forceCoup = calculResistanceEquipement(forceCoup);
		force -= forceCoup;
		// if (force > 0) {
		// parler("Aie");
		// } else {
		// equipementEjecte = ejecterEquipement();
		// parler("J'abandonne...");
		// }
		if (force == 0) {
			parler("Aie");
		} else {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
		}
		
		// post condition la force a diminuer
		assert force < oldForce;
		return equipementEjecte;
	}

	private int calculResistanceEquipement(int forceCoup) {
		String texte;
		texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0 && ( equipements[0] != null || equipements[1] != null)) {
			texte += "\nMais heureusement, grace a mon equipement sa force diminue de ";
			for (int i = 0; i < nbEquipement; i++) {
				if (equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER)) {
					resistanceEquipement += 8;
				} else {
					if(equipements[i] != null && equipements[i].equals(Equipement.CASQUE)) {
						System.out.println("Equipement casque");
					resistanceEquipement += 5;
					}
					
				}
			}
			if (forceCoup < resistanceEquipement) {
				resistanceEquipement = forceCoup;
			} 
			texte += resistanceEquipement + "!";
			
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		return forceCoup;
	}

	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'equipement de " + nom + "s'envole sous la force du coup.");
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] != null) {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}
		return equipementEjecte;
	}

	public void presente(String text) {
		System.out.println("Le soldat " + nom + text + ".");
	}
	
	public void equipe(Equipement equip) {
		presente(" s'equipe avec un " + equip.getNom());
		nbEquipement ++;
		equipements[nbEquipement-1]=equip;
	}
	
	public void sEquiper(Equipement equip) {
		switch(nbEquipement) {
			case 2:
				presente(" est deja bien protegee !");
				break;
			case 1 :
				if (equip == equipements[0]) {
					presente(" possede deja un " + equip.getNom());
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
