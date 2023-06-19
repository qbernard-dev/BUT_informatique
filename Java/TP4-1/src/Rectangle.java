
public class Rectangle extends FormeGeometrique implements Dessinable, Comparable<Rectangle> {
	
	private float largeur;
	private float longueur;
	
	public Rectangle(float x, float y, float largeur, float longueur) {
		super(x, y);
		this.largeur = largeur;
		this.longueur = longueur;
	}

	public float getLargeur() {
		return largeur;
	}

	public void setLargeur(float largeur) {
		this.largeur = largeur;
	}

	public float getLongueur() {
		return longueur;
	}

	public void setLongueur(float longueur) {
		this.longueur = longueur;
	}

	@Override
	public float surface() {
		// TODO Auto-generated method stub
		return largeur * longueur;
	}

	@Override
	public float perimetre() {
		// TODO Auto-generated method stub
		return 2 * largeur + 2 * longueur;
	}

	@Override
	public void dessiner(String couleur) {
		// TODO Auto-generated method stub
		System.out.println("Rectangle de couleur : "+couleur);
	}

	@Override
	public int compareTo(Rectangle o) {
		// TODO Auto-generated method stub
		if(this.surface() > o.surface()) {
			return 1;
		}
		else if(this.surface() == o.surface()) {
			return 0;
		}
		else {
			return -1;
		}
	}
	
	
}
