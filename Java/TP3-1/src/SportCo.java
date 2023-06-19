
public class SportCo extends Sport{
	private int nbJoueurs;
	
	public SportCo(int code, String libelle, int nbJoueurs) {
		super(code, libelle);
		this.nbJoueurs = nbJoueurs;
	}

	public int getNbJoueurs() {
		return nbJoueurs;
	}

	public void afficher() {
		System.out.println("Code : "+super.getCode()+"\nLibelle : "+super.getLibelle()+"\nNb Joueurs : "+this.nbJoueurs);
	}
	
	public String toString() {
		return "Code : "+super.getCode()+"\nLibelle : "+super.getLibelle()+"\nNb Joueurs : "+this.nbJoueurs;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
