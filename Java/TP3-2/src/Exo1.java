
public class Exo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employe e1 = new Ouvrier("bern",18,25);
		Employe e2 = new Ouvrier("abc",30,5);
		Employe e3 = new Ouvrier("deg",24,10);
		Employe e4 = new Gerant("pop",45,1);
		
		ListeEmploye a = new ListeEmploye();
		
		a.ajout(e1);
		a.ajout(e2);
		a.ajout(e3);
		a.ajout(e4);
		
		a.afficher();
		a.tri();
		a.afficher();
		a.selectionner();
	}

}
