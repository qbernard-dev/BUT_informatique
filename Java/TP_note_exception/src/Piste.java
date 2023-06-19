
public class Piste implements Equivalence{
	
	private String nom;
	private int longueur;
	private String couleur;
	private boolean ouvert;
	
	
	public Piste(String nom, int longueur, String couleur, boolean ouvert) {
		super();
		this.nom = nom;
		this.longueur = longueur;
		this.couleur = couleur;
		this.ouvert = ouvert;
	}

	
	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public int getLongueur() {
		return longueur;
	}


	public void setLongueur(int longueur) {
		this.longueur = longueur;
	}


	public String getCouleur() {
		return couleur;
	}


	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}


	public boolean isOuvert() {
		return ouvert;
	}


	public void setOuvert(boolean ouvert) {
		this.ouvert = ouvert;
	}
	
	public void afficher() {
		System.out.println(this.nom+", longueur : "+this.longueur+", difficulté : "+this.couleur+", ouverte : "+this.ouvert);
	}


	@Override
	public String toString() {
		return "Piste [nom=" + nom + ", longueur=" + longueur + ", couleur=" + couleur + ", ouvert=" + ouvert + "]";
	}
	
	public static void main(String[] args) {
		Piste p1 = new Piste("tpnote", 470, "rouge", true);
		
		p1.afficher();
	}

	@Override
	public boolean equivaut(Piste p1, Piste p2) {
		if(p1.getCouleur() == p2.getCouleur()) {
			int dif;
			dif = Math.abs(p1.getLongueur() - p2.getLongueur());
			if(dif <= 1000) {
				return true;
			}
		}
		
		return false;
	}

	
	

}
