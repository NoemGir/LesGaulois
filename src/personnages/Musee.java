package personnages;

public class Musee {
	private Trophee[] trophees = new Trophee[200];
	private int nbTrophee;
	
	public void donnerTrophees(Gaulois gaulois, Equipement equipement) {
		Trophee trophee = new Trophee(gaulois, equipement);
		trophees[nbTrophee]= trophee;
		nbTrophee ++;
	}

	public String extraireinstructionsCaml() {
		String texte = "";
		for (int i = 0; i < nbTrophee; i++) {
			texte += "   \"" + trophees[i].donnerNom() + "\", \"" + trophees[i].getEquipement().getNom() + "\";\n";
		}
		String Ocaml = "let musee = [ \n" + texte + "]";
		System.out.println(Ocaml);
		return Ocaml;
	}
}