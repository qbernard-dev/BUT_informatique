
public class Personne {

	private String numPasseport;
	private String nom;
	private String prenom;
	
	public Personne(String numPasseport, String nom, String prenom) {
		super();
		this.numPasseport = numPasseport;
		this.nom = nom;
		this.prenom = prenom;
	}

	public String getNumPasseport() {
		return numPasseport;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}
	
	
}
