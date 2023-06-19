import java.util.ArrayList;

public class Domaine {
	
	private String nom;
	private ArrayList<Piste> pistes = new ArrayList<Piste>(100);
	
	public Domaine(String nom) {
		super();
		this.nom = nom;

	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public ArrayList<Piste> getPistes() {
		return pistes;
	}

	public void setPistes(ArrayList<Piste> pistes) {
		this.pistes = pistes;
	}
	
	
	public void afficher() {
		System.out.println("DOMAINE "+this.nom+"\n"+this.pistes+"\n");
	}
	
	public int est_presente(String nomPiste) {

		for (int i = 0; i < pistes.size(); i++) {
			if(nomPiste.equals(pistes.get(i).getNom()) == true) {
				return 1;
			}
	}
	
		return -1;
	}
	
	public boolean ajouter(Piste p) {
		int res;
		res = est_presente(p.getNom());
		
		if(res == -1) {
			pistes.add(p);
			return true;
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		
		Domaine d1 = new Domaine("San Bernaro");
		d1.afficher();
	}


	
	
	
	
	

}
