package personnages;

import villageGaulois.Musee;

public class Gaulois {
	private String nom;
	private int force;
	private int nbTrophees;
	private int effetPotion = 1;
	private Equipement[] trophees = new Equipement[100];

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "<< " + texte + " >>");
	}

//	private String prendreParole() {
//		return "Le Gaulois " + nom + " :" ;
//	}

	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}

//	public void frapper(Romain romain) {
//		System.out.println(nom + " envoie un grand coup dans la machoîre de " + romain.getNom());
//		romain.recevoirCoup(force/3);
//	}

	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la machoire de " + romain.getNom());
		Equipement[] trophees2 = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; i < trophees2.length; i++) {
			if (trophees2[i] != null ) {
				this.trophees[nbTrophees] = trophees2[i];
				nbTrophees++;
			}
		}
	}

	public void boirePotion(int forcePotion) {
		effetPotion = +forcePotion;
		parler("Merci Druide, je sens que ma force est " + forcePotion + " fois decuplee.");
	}
	
	public void faireUneDonnation(Musee musee) {
		String texte = "";
		while (nbTrophees >0) {
			nbTrophees -= 1;
			musee.donnerTrophees(this, trophees[nbTrophees]);
			texte += " - " + trophees[nbTrophees].getNom() + "\n";
			trophees[nbTrophees]=null;
		}
		parler("Je donne au musee tous mes trophees : \n" + texte);
	}


	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Asterix", 8);
		System.out.println(asterix.nom);
		System.out.println(asterix);
		System.out.println(asterix.prendreParole());
		asterix.parler("hehe");
		asterix.boirePotion(6);
	}
}
