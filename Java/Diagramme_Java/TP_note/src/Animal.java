public class Animal{

	private String nom;
	private int identifiant;
	private Client proprietaire;
	private Enregistrement enregistre;
	
	public Animal(String nom, int identifiant, Enregistrement enregistre) {
		this.nom = nom;
		this.identifiant = identifiant;
		this.enregistre = enregistre;
	}

	public String getNom() {
		return nom;
	}

	public int getIdentifiant() {
		return identifiant;
	}
	
	public Client getProprietaire() {
		return proprietaire;
	}

	public Enregistrement getEnregistre() {
		return enregistre;
	}
	
	public void affecterClient(Client c) {
		this.proprietaire = c;
	}

	public String toString() {
		return "Animal [nom=" + nom + ", identifiant=" + identifiant + ", proprietaire=" + proprietaire + "]";
	}
	
	public static void main(String[] args) {
		Enregistrement e1 = new Enregistrement(1,"rue palaud","12/03/2023");
		Animal a1 = new Chat("chat1",1,e1);
		
		Enregistrement e2 = new Enregistrement(2,"rue palaud","01/03/2023");
		Animal a2 = new Chat("chien1",1,e1);
		
		Client c1 = new Client("bernard", "quentin",1, null);
		c1.adopte(a1);
	}	
	
	
}
