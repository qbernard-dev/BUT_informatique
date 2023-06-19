
public class Jouer {
	private String monRôle;
	private Film film; 
	private Acteur acteur;

	

	public Jouer(String monRôle, Film film, Acteur acteur) {
		super();
		this.monRôle = monRôle;
		this.film = film;
		this.acteur = acteur;
	}

	public String getMonRôle() {
		return monRôle;
	}
	
	
}
