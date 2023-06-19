import java.util.ArrayList;

public class Client {

	private String nom;
	private String prenom;
	private int numClient;
	private ArrayList<Animal> mesanimaux;

	public Client(String nom, String prenom, int numClient, ArrayList<Animal> mesanimaux) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.numClient = numClient;
		this.mesanimaux = new ArrayList<Animal>();
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public int getNumClient() {
		return numClient;
	}
	
	public ArrayList<Animal> getMesanimaux() {
		return mesanimaux;
	}
	
	public void adopte(Animal a) {
		mesanimaux.add(a);
	}
	
	public void afficheMesAnimaux() {
		System.out.println("Mes animaux : "+this.mesanimaux);
	}

	public String toString() {
		return "Client [nom=" + nom + ", prenom=" + prenom + ", numClient=" + numClient + ", mesanimaux=" + mesanimaux
				+ "]";
	}
	
	
	
}
