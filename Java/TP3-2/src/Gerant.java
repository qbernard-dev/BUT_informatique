
public class Gerant extends Employe {
	
	private int nb_h_g;

	public Gerant(String nom, int age, int nb_a) {
		super(nom, age, nb_a);
		this.nb_h_g = 30;

	}

	public int getNb_h_g() {
		return nb_h_g;
	}

	public void setNb_h_g(int nb_h_g) {
		this.nb_h_g = nb_h_g;
	}
	

	@Override
	public float salaire() {
		// TODO Auto-generated method stub
		return 5 * nb_h_g * (20 + nb_a/2);
	}

	@Override
	public String afficher() {
		// TODO Auto-generated method stub
		return  "Gerant   "+"Nom : "+this.getNom()+"Age : "+this.getAge()+"Annee ancienté : "+this.getNb_a()+"Nb heure : "+this.nb_h_g+"Numéro : "+this.getNum()+"Salaire : "+this.salaire();
	}

	@Override
	public String toString() {
		return "Gerant [afficher()=" + afficher() + "]";
	}
	
	
}
