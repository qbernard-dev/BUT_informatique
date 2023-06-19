import java.util.ArrayList;

public class Zone_geo {

	private String nom;
	private ArrayList<Client> array;

	public Zone_geo(String nom) {
		super();
		this.nom = nom;
		this.array = new ArrayList<Client>(10);
	}

	public String getNom() {
		return nom;
	}

	@Override
	public String toString() {
		return "Zone_geo [nom=" + nom + ", array=" + array + "]";
	}
	
	public void ajout(Client c) {
		if(!array.contains(c)) {
			array.add(c);
		}
	}
	
	public void supprimmer(Client c) {
		array.remove(c);
	}
	
	
}
