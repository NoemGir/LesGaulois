package personnages;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois = 0;
	
	public Village(String nom, int nbVillageoisMaximum) {
		this.nom = nom;
		this.villageois = new Gaulois[nbVillageoisMaximum];
	}
	
	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public String getNom() {
		return nom;
	}
	
	public void ajouterHabitant(Gaulois gaulois) {
		villageois[nbVillageois] = gaulois ;
		nbVillageois += 1 ;
	}
	
	public Gaulois trouverHabitant(int numero) {
		return villageois[numero-1];
	}
	
	public void afficherVillageois() {
		int i;
		System.out.println("Dans " + getNom() + " du chef " + chef.getNom() 
		+ " vivent les legendaires gaulois :");
		for (i=0; i<nbVillageois; i++) {
			System.out.println(" - " + villageois[i].getNom() );
		}
	}
	
	public static void main(String[] args) {
		Village village = new Village("Village des Irr�ductibles",30);
		
//		Gaulois gaulois = village.trouverHabitant(30);
//		aucun gaulois n'a �t� mit dans le village donc cette case est vide
		
		Chef abraracourcix = new Chef("Abraracourcix", 6,1, village);
		village.setChef(abraracourcix);
		
		Gaulois asterix = new Gaulois("Ast�rix", 8);
		village.ajouterHabitant(asterix);
		
//		Gaulois gaulois = village.trouverHabitant(1);
//		System.out.println(gaulois);
//		On reçoit les informations de Asterix, qui est le premier gaulois villageois enregistré
// 		dans le village.
		
		Gaulois obelix = new Gaulois("Ob�lix", 25);
		village.ajouterHabitant(obelix);
		
		village.afficherVillageois();
	}
	
}	