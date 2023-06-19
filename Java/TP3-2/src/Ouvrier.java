
public class Ouvrier extends Employe {
	
	private int nb_h_o;


	public Ouvrier(String nom, int age, int nb_a) {
		super(nom, age, nb_a);
		this.nb_h_o = 35;

	}



	public int getNb_h_o() {
		return nb_h_o;
	}

	public void setNb_h_o(int nb_h_o) {
		this.nb_h_o = nb_h_o;
	}

	@Override
	public float salaire() {
		// TODO Auto-generated method stub
		return 4 * nb_h_o * (10 + nb_a/2);
	}

	@Override
	public String afficher() {
		// TODO Auto-generated method stub
		return "Ouvrier  "+"Nom : "+this.getNom()+"Age : "+this.getAge()+"Annee ancienté : "+this.getNb_a()+"Nb heure : "+this.nb_h_o+"Numéro : "+this.getNum()+"Salaire : "+this.salaire();

	}

	@Override
	public String toString() {
		return "Ouvrier [afficher()=" + afficher() + "]";
	}
	
	
	
}
