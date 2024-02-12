import java.util.Objects;

public class Acteur {
	
	private String nom;
	private String prenom;
	
	public Acteur(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}
	
	public void afficher() {
		System.out.println(this.prenom+" "+this.prenom);
	}

	@Override
	public String toString() {
		return this.prenom+" "+this.nom;
	}
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(nom, prenom);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Acteur other = (Acteur) obj;
		return Objects.equals(nom, other.nom) && Objects.equals(prenom, other.prenom);
	}

	public static void main(String[] args) {
		Acteur a1 = new Acteur("Brad","Pitt");
		Acteur a2 = new Acteur("Brad","Pitt");
		a1.afficher();
		a1.equals(a2);
	}
	
	
}
