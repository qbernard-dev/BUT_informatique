
public class Date {
	private int jour;
	private int mois;
	private int annee;
	
	
	public Date(int jour, int mois, int annee) {
		super();
		this.jour = jour;
		this.mois = mois;
		this.annee = annee;
	}

	/*
	public Date() {
		super();
		this.jour = Saisir.entier();
		this.mois = Saisir.entier();
		this.annee = Saisir.entier();
	}
	*/


	public int getJour() {
		return jour;
	}

	public void setJour(int jour) {
		this.jour = jour;
	}

	public int getMois() {
		return mois;
	}

	public void setMois(int mois) {
		this.mois = mois;
	}

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}
	
	public void afficher() {
		System.out.println("Jour : "+this.jour+"\nMois : "+this.mois+"\nAnnée : "+this.annee);
	}
	
	public String toString() {
		return "Jour : "+this.jour+"\nMois : "+this.mois+"\nAnnée : "+this.annee;
	}
	
	public static void main (String[] args) {
		/*
		Date d1 = new Date();
		d1.afficher();
		*/
	}
	
	
}
