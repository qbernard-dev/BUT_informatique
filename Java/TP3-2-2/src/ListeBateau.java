import java.util.ArrayList;
import java.util.Scanner;

public class ListeBateau {

    static int ligne;
    static Scanner entree=new Scanner (System.in);
	
	private ArrayList<Bateau> boat = new ArrayList<Bateau>(100);

	public ListeBateau() {
		super();
	}
	
	public void ajout(Bateau b) {
		boat.add(b);
	}
	
	public void afficher() {
		for (int i = 0; i < boat.size(); i++) {
			System.out.println(boat.get(i));
		}
	}
	
	public float retourner(String nom) {
		for (int i = 0; i < boat.size(); i++) {
			if(boat.get(i).getNom().equals(nom)) {
				return boat.get(i).getLongueur();
			}
		}
		return -1;
	}
	
	public void afficher_port(int p) {
		for (int i = 0; i < boat.size(); i++) {
			if(boat.get(i).getPort() == p) {
				System.out.println(boat.get(i).afficher());
			}
		}
	}
}
