
public class Client {

	private int numero;
	private String nom;
	private String adresse;
	
	public Client(int numero, String nom, String adresse) {
		super();
		this.numero = numero;
		this.nom = nom;
		this.adresse = adresse;
	}

	public int getNumero() {
		return numero;
	}

	public String getNom() {
		return nom;
	}

	public String getAdresse() {
		return adresse;
	}
	
	public void afficher() {
		System.out.println("num : "+this.numero+" nom : "+this.nom+"  ardresse : "+this.adresse);
	}

	@Override
	public String toString() {
		return "Client [numero=" + numero + ", nom=" + nom + ", adresse=" + adresse + "]";
	}
	
	
	
}
