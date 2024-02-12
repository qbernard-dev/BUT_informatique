import java.util.Date;
import java.util.Objects;

public class Seance {

	private Date date;
	private String typeSeance;
	private Film monFilm;
	
	public Seance(Date date, String typeSeance) {
		super();
		this.date = date;
		this.typeSeance = typeSeance;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getTypeSeance() {
		return typeSeance;
	}
	public void setTypeSeance(String typeSeance) {
		this.typeSeance = typeSeance;
	}
	
	public void affecterFilm(Film f) {
		this.monFilm=f;
	}
	
	public void ajouterProgrammer(Film f) {
		if (f==null) {
			System.out.println("Pas de film");
		}
		else {
			affecterFilm(f);
		}
	}
	
	public void affiche() {
		if (this.monFilm==null) {
			System.out.println(date+""+typeSeance+"Aucun film n'est preogramme");
		}
		else {
			System.out.println(date+""+typeSeance+monFilm);
		}
	}
	
	public void enleverFilm(Film f) {
		this.monFilm=null;
	}
	public void enleverProgrammer(Film f) {
		if(this.monFilm !=null) {
			System.out.println("Le film a ete supprimer");
			enleverFilm(f);
		}
		else {
			System.out.println("Il n'y a pas de film programmé pour cette séance");
		}
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(date, typeSeance);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Seance other = (Seance) obj;
		return Objects.equals(date, other.date) && Objects.equals(typeSeance, other.typeSeance);
	}
}

	