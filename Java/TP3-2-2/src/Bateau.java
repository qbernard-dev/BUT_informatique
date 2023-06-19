
abstract class Bateau {
	
	private String nom;
	private float poids;
	private int port;
	private float longueur;
	
	public Bateau(String nom, float poids, int port, float longueur) {
		super();
		this.nom = nom;
		this.poids = poids;
		this.port = port;
		this.longueur = longueur;
	}

	public String getNom() {
		return nom;
	}

	public float getPoids() {
		return poids;
	}

	public int getPort() {
		return port;
	}

	public float getLongueur() {
		return longueur;
	}
	
	abstract public String afficher();
	abstract public float taxe();
	
}
