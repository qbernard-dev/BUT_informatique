
public class Client {
	private int num;
	private String nom;
	private String adresse;
	
	static private int nb = 0;
	
	/*
	public Client() {
		super();
		this.num = nb+1;
		nb++;
		this.nom = Saisir.chaine();
		this.adresse = Saisir.chaine();
	}
	*/
	
	public Client(String nom, String adresse) {
		super();
		this.num = nb+1;
		nb++;
		this.nom = nom;
		this.adresse = adresse;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public int getNum() {
		return num;
	}
	
	public void afficher() {
		System.out.println("Num client : "+this.num+"\nNom : "+this.nom+"\nAdresse : "+this.adresse);
	}
	
	public String toString() {
		return "Num client : "+this.num+"\nNom : "+this.nom+"\nAdresse : "+this.adresse;
	}
	
	public static void main (String[] args) {
		/*
		Client c1 = new Client();
		Client c2 = new Client();
		
		c1.afficher();
		c2.afficher();
		*/
	}
	
}
