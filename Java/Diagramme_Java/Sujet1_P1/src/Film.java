import java.util.ArrayList;
import java.util.Objects;

public class Film {
	
	private String titre;
	private String nationalite;
	private float duree;
	private String resume;
	private ArrayList <Acteur> acteurs;
	private ArrayList<Seance> mesSeances;
	
	public Film(String titre, String nationalite, float duree, String resume) {
		super();
		this.titre = titre;
		this.nationalite = nationalite;
		this.duree = duree;
		this.resume = resume;
		this.acteurs = new ArrayList<Acteur>(100);
		this.mesSeances = new ArrayList<Seance>(10);
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public String getTitre() {
		return titre;
	}

	public String getNationalite() {
		return nationalite;
	}

	public float getDuree() {
		return duree;
	}
	
	public void afficher() {
		System.out.println(this.titre+"    Film "+this.nationalite+" de "+this.duree+" mn");
	}

	@Override
	public String toString() {
		return "Film [titre=" + titre + ", nationalite=" + nationalite + ", duree=" + duree + ", resume=" + resume
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(titre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		return Objects.equals(titre, other.titre);
	}
	
	public boolean contientActeur(Acteur a) {
		return acteurs.contains(a);
	}
	
	public void ajoutez_acteur(Acteur a) {
		acteurs.add(a);
	}
	
	public void ajouterSeance(Seance s) {
		mesSeances.add(s);
	}
}
