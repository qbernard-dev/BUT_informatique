import java.util.ArrayList;

public class Animalerie {

	private String nom;
	private String adresse;
	private ArrayList<Animal> heberge;
	private ArrayList<Client> clients;
	
	public Animalerie(String nom, String adresse, ArrayList<Animal> heberge, ArrayList<Client> clients) {
		super();
		this.nom = nom;
		this.adresse = adresse;
		this.heberge = new ArrayList<Animal>();
		this.clients = new ArrayList<Client>();
	}

	public String getNom() {
		return nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public ArrayList<Animal> getHeberge() {
		return heberge;
	}
	
	public void herberge(Animal a) {
		heberge.add(a);
	}
	
	public void possede(Client c) {
		clients.add(c);
	}

	public String toString() {
		return "Animalerie [nom=" + nom + ", adresse=" + adresse + ", heberge=" + heberge + ", clients=" + clients
				+ "]";
	}
	
	
}
