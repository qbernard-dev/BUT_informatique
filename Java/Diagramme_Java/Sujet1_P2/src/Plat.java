
public class Plat {

	public String nom;
	private Recette re;
	
	public Plat(String nom, Recette re) {
		this.nom = nom;
		this.re = re;
	}

	public String getNom() {
		return nom;
	}

	public Recette getRe() {
		return re;
	}

	@Override
	public String toString() {
		return "Plat [nom=" + nom + ", re=" + re + "]";
	}
	
	
	
}
