import java.util.ArrayList;
import java.util.Scanner;

public class Voiture {
	private String immat;
	private String modele;
	private int km;
	private float tarif;
	
    Scanner entree = new Scanner(System.in);
	
    /*
	public Voiture() {
		super();
		this.immat = Saisir.chaine();
		this.modele = Saisir.chaine();
		this.km = Saisir.entier();
		this.tarif = Saisir.reelf();
	}
	*/
    
    public Voiture(String immat, String modele, int km, float tarif) {
		super();
		this.immat = immat;
		this.modele = modele;
		this.km = km;
		this.tarif = tarif;
	}
    
	public int getKm() {
		return km;
	}

	public void setKm(int km) {
		this.km = km;
	}

	public float getTarif() {
		return tarif;
	}

	public void setTarif(float tarif) {
		this.tarif = tarif;
	}

	public String getImmat() {
		return immat;
	}

	public String getModele() {
		return modele;
	}
	
	public void afficher() {
		System.out.println("Immatriculation : "+this.immat+"\nModèle : "+this.modele+"\nKm : "+this.km+"\ntarif : "+this.tarif);
	}
	
	public String toString() {
		return "Immatriculation : "+this.immat+"\nModèle : "+this.modele+"\nKm : "+this.km+"\ntarif : "+this.tarif;
	}
	
	public static void main (String[] args) {
		/*
		ArrayList<Voiture> voitures = new ArrayList<Voiture>(10);
		voitures.add(new Voiture());
		voitures.add(new Voiture());
		
		for(int i = 0; i < 10; i++) {
			voitures.get(i).afficher();
		}
		*/
	}
}
