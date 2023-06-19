
public class Moteur extends Bateau{
	
	protected float puissance;

	public Moteur(String nom, float poids, int port, float longueur, float puissance) {
		super(nom, poids, port, longueur);
		this.puissance = puissance;
	}

	public float getPuissance() {
		return puissance;
	}

	@Override
	public String afficher() {
		// TODO Auto-generated method stub
		return "Moteur  "+"Nom : "+this.getNom()+"poids : "+this.getPoids()+"port : "+this.getPort()+"Long : "+this.getLongueur()+"puissance :"+this.puissance;
	}

	@Override
	public String toString() {
		return "Moteur [afficher()=" + afficher() + "]";
	}

	@Override
	public float taxe() {
		// TODO Auto-generated method stub
		return 70 * getLongueur() + 5 * puissance;
	}
	
	
	
}
