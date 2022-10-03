package personnages;

import java.util.Random;

public class Druide {
	private String nom;
	private int forcePotion = 1;
	private int effetPotionMin;
	private int effetPotionMax;
	
	public Druide(String nom, int effetPotionMin, int effetPotionMax) {
		this.nom = nom;
		this.effetPotionMin = effetPotionMin;
		this.effetPotionMax = effetPotionMax;
		parler("Bonjour, je suis le druide " + nom + " et ma potion peut aller d'une force " + effetPotionMin + " à "
				+ effetPotionMax + " .");
	}
	
	
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
			System.out.println(prendreParole() + "« " + texte + " »");
	
	}
	
	private String prendreParole() {
		return "Le druide " + nom + " :" ;
	}
	
	public void preparerPotion() {
		Random random = new Random();
		forcePotion =  random.nextInt(effetPotionMax - effetPotionMin +1);
		forcePotion += effetPotionMin;
		faireParler();
	}
	
	public void faireParler() {
		if (forcePotion > 7) {
			parler("J'ai préparé\n"
					+ "une super potion de force : "+ forcePotion);
		}
		else {
			parler("Je n'ai pas trouvé tous les ingrédients, ma potion est\n"
					+ "seulement de force : " + forcePotion );
		}
		
	}
	
	public void booster(Gaulois gaulois) {
		String nomGaulois = gaulois.getNom();
		if ("Obélix".equals(nomGaulois)) {
			parler("Non, Obélix !... Tu n’auras pas de potion\n"
					+ "magique ! ");
		} else {
			gaulois.boirePotion(forcePotion);
		}
		
	}
	
		public static void main(String[] args) {
			Druide panoramix = new Druide("Panoramix",5, 10 );
			panoramix.preparerPotion();
		}
	
}
