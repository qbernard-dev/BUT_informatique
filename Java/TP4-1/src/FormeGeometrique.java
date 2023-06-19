
abstract class FormeGeometrique {
	
	private float x;
	private float y;

	
	public FormeGeometrique(float x, float y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	abstract public float surface();
	abstract public float perimetre();
	
	public void deplacer(float nv_x, float nv_y) {
		this.x = nv_x;
		this.y = nv_y;
	}
	
	public void afficherPosition() {
		System.out.println("x : "+x+" y : "+y);
	}

	@Override
	public String toString() {
		return "FormeGeometrique [x=" + x + ", y=" + y + "]"+surface();
	}
	
	
}
