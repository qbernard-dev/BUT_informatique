
public class Yatch extends Moteur{
	
	private int nb;

	public Yatch(String nom, float poids, int port, float longueur, float puissance, int nb) {
		super(nom, poids, port, longueur, puissance);
		this.nb = nb;
	}

	public int getNb() {
		return nb;
	}
		
	public void setNb(int nb) {
		this.nb = nb;
	}

	public String afficher() {
		// TODO Auto-generated method stub
		return "Moteur  "+"Nom : "+this.getNom()+"poids : "+this.getPoids()+"port : "+this.getPort()+"Long : "+this.getLongueur()+"puissance :"+this.getPuissance()+"NB : "+this.nb;
	}

	@Override
	public String toString() {
		return "Yatch [afficher()=" + afficher() + "]";
	}

	
	public float taxe() {
		// TODO Auto-generated method stub
		return 70 * getLongueur() + 5 * puissance + 20 * nb;
	} 
}
