import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;

public class Etudiant {

	private int id;
	private String nom;
	private String prenom;
	private HashMap<Cours, Float> les_notes = new HashMap<>();
	
	static private int nb = 0;
	
	public Etudiant(int nb, String nom, String prenom) {
		this.id = nb++;
		this.nom = nom;
		this.prenom = prenom;
	}
	
	
	public int getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public HashMap<Cours, Float> getLes_notes() {
		return les_notes;
	}

	public static int getNb() {
		return nb;
	}

	public void ajout(Cours cours) {
		Scanner clavier = new Scanner(System.in);
		System.out.println("Rentrer une note : ");
		int note = clavier.nextInt();
		while (note < 0 && note > 20) {
			System.out.println("Refait : ");
		}
		clavier.close();
		les_notes.put(cours, (float) note);
	}
	
	public void modifie(Cours cours) {
		Scanner clavier = new Scanner(System.in);
		System.out.println("Rentrer la nouvelle note : ");
		int note = clavier.nextInt();
		while (note < 0 && note > 20) {
			System.out.println("Refait : ");
		}
		clavier.close();
		les_notes.replace(cours, (float) note);
	}
	
	public void supprime(Cours cours) {
		les_notes.remove(cours);
		System.out.println("Suppresion réussie");
	}
	
	public float moyenne() {
		int i = 0;
		float somme = 0;
		for (Entry<Cours, Float> entry : les_notes.entrySet()) {
			Cours key = entry.getKey();
			Float val = entry.getValue();
			somme += val;
			i++;
		}
		if (i == 0) {
			System.out.println("on ne peut pas faire une division par 0");
			return -1;
		}
		return somme / i;
	}
	
	public void affiche_note(Cours cours) {
		System.out.println(les_notes.get(cours));
	}
	
	public void affiche_min_note(Cours cours) {
		float mini = (float) 20.0;
		for (Entry<Cours, Float> entry : les_notes.entrySet()) {
			Cours key = entry.getKey();
			Float val = entry.getValue();
			float min = val;
			if (min < mini) {
				mini = val;
			}
		}
		System.out.println("Le min est de : "+mini);
	}
	
	public void affiche_max_note(Cours cours) {
		float maxi = (float) 0.0;
		for (Entry<Cours, Float> entry : les_notes.entrySet()) {
			Cours key = entry.getKey();
			Float val = entry.getValue();
			float max = val;
			if (max < maxi) {
				maxi = val;
			}
		}
		System.out.println("Le max est de : "+maxi);
	}
}
