
public class Voiliers extends Bateau{

	private float surface;

	public Voiliers(String nom, float poids, int port, float longueur, float surface) {
		super(nom, poids, port, longueur);
		this.surface = surface;
	}

	public float getSurface() {
		return surface;
	}

	@Override
	public String afficher() {
		// TODO Auto-generated method stub
		return "Voilier  "+"Nom : "+this.getNom()+"poids : "+this.getPoids()+"port : "+this.getPort()+"Long : "+this.getLongueur()+"surface : "+this.surface;
	}

	@Override
	public String toString() {
		return "Voiliers [afficher()=" + afficher() + "]";
	}

	@Override
	public float taxe() {
		// TODO Auto-generated method stub
		return 50 * getLongueur();
	}
	
	
	
	
}
