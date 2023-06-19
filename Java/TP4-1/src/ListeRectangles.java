import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListeRectangles {
	
	private List<Object> listeR ;

	public ListeRectangles() {
		super();
		this.listeR = new ArrayList<Object>(100);
	}
	
	public void ajout(Rectangle r) {
		listeR.add(r);
	}
	
	public void afficher() {
		for (int i = 0; i < listeR.size(); i++) {
			System.out.println(listeR.get(i));
		}
	}
	
	public void trie() {
		Object[] a = listeR.toArray();
		Arrays.sort(a);
		listeR = Arrays.asList(a);
	}
	
	
	public static void main(String[] args) {
		
		ListeRectangles listeR = new ListeRectangles();

		Rectangle r1 = new Rectangle(0,0,5,5);
		Rectangle r2 = new Rectangle(0,0,5,10);
		Rectangle r3 = new Rectangle(0,0,2,15);
		
		listeR.ajout(r1);
		listeR.ajout(r2);
		listeR.ajout(r3);
		
		listeR.afficher();
		listeR.trie();
		listeR.afficher();
		
	}
}
