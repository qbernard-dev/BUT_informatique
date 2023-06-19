import java.util.ArrayList;

public class Principale {
	public static void main(String[] args) {
		Film f1 = new Film("BIS","Français",102,"Eric et Patrice ...");
		Acteur a1 = new Acteur("Dubosc","Frank");
		Acteur a2 = new Acteur("Merad", "Kad");
		Acteur a3 = new Acteur("Lamy","Alexendra");
		
		f1.ajoutez_acteur(a1);
		f1.ajoutez_acteur(a2);
		f1.ajoutez_acteur(a3);
		
		Film f2 = new Film("PAPA OU MAMAN","Français",104,"Florence et Vincent");
		Acteur a4 = new Acteur("Foïs","Marina");
		Acteur a5 = new Acteur("Lafitte","Laurent");
		
		f2.ajoutez_acteur(a4);
		f2.ajoutez_acteur(a5);
		
		ArrayList<Seance>seances = new ArrayList<Seance>(4);
		Seance s1 = new Seance("18/03/2017","matinée");
		Seance s2 = new Seance("18/03/2017","début après-midi");
		Seance s3 = new Seance("18/03/2017","fin après-midi");
		Seance s4 = new Seance("18/03/2017","soirée");
		
		seances.add(s1);
		seances.add(s2);
		seances.add(s3);
		seances.add(s4);
		
		s1.ajouterProgrammer(f1);
		s4.ajouterProgrammer(f1);
		s2.ajouterProgrammer(f2);
		s3.ajouterProgrammer(f2);
		
		s1.affiche();
		s2.affiche();
		s3.affiche();
		s4.affiche();
	}
}
