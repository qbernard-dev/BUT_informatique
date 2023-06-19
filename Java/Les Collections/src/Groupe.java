import java.util.HashSet;
import java.util.Iterator;

public class Groupe {

	private String nom_groupe;
	private HashSet<Etudiant> les_etudiants = new HashSet<>();
	
	public Groupe(String nom_groupe) {
		this.nom_groupe = nom_groupe;
	}

	public String getNom_groupe() {
		return nom_groupe;
	}

	public HashSet<Etudiant> getLes_etudiants() {
		return les_etudiants;
	}
	
	public void ajout(Etudiant e) {
		les_etudiants.add(e);
		System.out.println("ajout réussie");
	}
	
	public void supprimer(Etudiant e) {
		les_etudiants.remove(e);
		System.out.println("suppresion réussie");
	}
	
	public int nbEtudiant() {
		return les_etudiants.size();
	}
	
	public void moy() {
		int somme = 0;
		for (int i = 0; i < les_etudiants.size(); i++) {
			somme = somme + 
		}
	}
	
	
}
