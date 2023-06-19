
public class Cercle extends FormeGeometrique implements Dessinable{
	
	private float rayon;

	public Cercle(float x, float y, float rayon) {
		super(x, y);
		this.rayon = rayon;
	}

	public float getRayon() {
		return rayon;
	}

	public void setRayon(float rayon) {
		this.rayon = rayon;
	}

	@Override
	public float surface() {
		// TODO Auto-generated method stub
		return (float) (Math.PI * (rayon * rayon));
	}

	@Override
	public float perimetre() {
		// TODO Auto-generated method stub
		return (float) (2 * Math.PI * rayon);
	}

	@Override
	public void dessiner(String couleur) {
		// TODO Auto-generated method stub
		System.out.println("Cercle de couleur : "+couleur);
	}
	
	
}
