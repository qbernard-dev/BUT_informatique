import java.util.ArrayList;

public class Restaurant {

	public String nom;
	public String adresse;
	private ArrayList<Plat> plats;
	
	public Restaurant(String nom, String adresse, ArrayList<Plat> plats) {
		this.nom = nom;
		this.adresse = adresse;
		this.plats = new ArrayList<Plat>(20);
	}
	
	public void ajoutPlat(Plat p) {
		plats.add(p);
	}
	
	public void suppPlat(Plat p) {
		plats.remove(p);
	}
	
	public void ajoutCarte(Plat p) {
		for (int i = 0; i < plats.size(); i++) {
			if(!plats.get(i).getNom().equals(p.getNom())) {
				ajoutPlat(p);
			}
		}
	}
	
	public void suppCarte(Plat p) {
		for (int i = 0; i < plats.size(); i++) {
			if(!plats.get(i).getNom().equals(p.getNom())) {
				suppPlat(p);
			}
		}
	}

	@Override
	public String toString() {
		return "Restaurant [nom=" + nom + ", adresse=" + adresse + ", plats=" + plats + "]";
	}
	
	
	
}
